package com.Versicherung.service;

import com.Versicherung.model.Firma.Firma.*;
import com.Versicherung.config.Validator;
import com.Versicherung.model.Abfrage;
import com.Versicherung.model.Angebot;
import com.Versicherung.model.Detail;
import com.Versicherung.model.Firma.*;
import com.Versicherung.repository.RechnungRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RechnungService {
    // erstellen wir eine statische Nummer, um jedem Angebot eine ID-Nummer zuzuweisen.
    private static int generadetid = 1;

    // Mit diesem Code können wir das Objekt der Repository-Klassen aufrufen,
    // die dem Kontex mit der @Repository-Annotation hinzugefügt wurden
    @Autowired
    private RechnungRepsitory rechnungRepsitory;

    // hier können wir auf die Validator-Klasse zugreifen,
    // die erstellt wurde, um zu prüfen,
    // ob die POST anfragen oder die Variablen im gewünschten Format eingegeben werden
    @Autowired
    private Validator validator;


    // nach irgendeiner Frage listet die Angebote der registrierten Unternehmen mit dieser Method auf
    public List<Angebot> rechnung(Abfrage abfrage) {
        //wir erhalten die Datenbank mit Informationen über Unternehmen von contex
        List<Firma> firmalist = rechnungRepsitory.getFirmaliste();

        // wir erstellen eine Angebotsliste, in der wir die Angebote der Unternehmen speichern, die wir dem Nutzer zeigen wollen
        List<Angebot> angebotList = new ArrayList<>();

        //mit dieser Schleife wird die Berechnung des Gebots, das jedes Unternehmen auf die Anfrage abgeben muss, durchgeführt
        for (int i = 0; i < firmalist.size(); i++) {
            // das Angebot wird hier berechnet
            Angebot angebot=rechnung2(abfrage, firmalist.get(i));
            // dann in die Liste für den Benutzer aufgenommen werden
            angebotList.add(angebot);
            //außerdem wird jedes Angebot auch in die Liste im Kontext aufgenommen, falls es in Frage gestellt wird
            rechnungRepsitory.speichern(angebot);
        }

        return angebotList;
    }
   // Wir machen die individuelle Berechnung mit dieser Methode,
   // dazu benötigen wir eine Abfrage und Firmenbeitragsanteile Informationen
    private Angebot rechnung2(Abfrage abfrage, Firma firma) {
        Angebot angebot = new Angebot();
        // es wurden Methoden geschrieben,
        // um jeden Beitrag gemäß den festgelegten Bedingungen zu berechnen,
        // und die Daten dieser Methoden werden aufbewahrt.
        float beitrag, basisbt,alterbt,postzahlbt,deckungbt;
        basisbt=round(findBasisBeitrag(abfrage, firma));
        alterbt=round(findAlterzusclag(abfrage, firma, basisbt));
        postzahlbt=round(findPostzahlbeitrag(abfrage,firma,basisbt));
        deckungbt=round(findDeckungzuschlag(abfrage, firma,basisbt));
        beitrag=round(basisbt+alterbt+postzahlbt+deckungbt);

        // bit obigen Daten wird dann ein Angebot erstellt.
        angebot.setId(generadetid);
        angebot.setFirmaName(firma.getFirmaName());
        angebot.setVersicherung(abfrage.getVersicherunsgsart());
        angebot.setBeitrag(beitrag);
        angebot.setDetail(new Detail(basisbt,alterbt,postzahlbt,deckungbt));

        generadetid++;
        return angebot;
    }


    private float findBasisBeitrag(Abfrage abfrage, Firma firma) {
        float basisbeitrag = 0;
        if (validator.validateVersicherungsart(abfrage)) {
            for (Versicherungsart v : firma.getVersicherungsartList()) {
                if (abfrage.getVersicherunsgsart().equalsIgnoreCase(v.getArtName())) {
                    basisbeitrag = v.getBeitrag();
                    break;
                }
            }
        }

        return basisbeitrag;
    }

    private float findAlterzusclag(Abfrage abfrage, Firma firma, float basisBeitrag) {
        float alterbeitrag = 0;

        if (validator.validateAge(abfrage)) {
            for (Alter a : firma.getAlterList()) {
                if (getAge(abfrage).equals(a.getBezeichnung())) {
                    alterbeitrag = a.getBeitrag();
                    break;
                }
            }
        }
        return alterbeitrag*basisBeitrag;
    }

    private float findPostzahlbeitrag(Abfrage abfrage, Firma firma, float basisBeitrag) {
        float postzahlbeitrag = 0;
        if (validator.validatePostZahl(abfrage)) {
            for (Postzahl p : firma.getPostzahlList()) {
                if(getPostZahl(abfrage).equals(p.getBezeichnung())){
                    postzahlbeitrag=p.getBeitrag();
                    break;
                }
            }
        }
        return postzahlbeitrag*basisBeitrag;
    }

    private float findDeckungzuschlag(Abfrage abfrage, Firma firma,float basisBeitrag){
        float deckungbeitrag=0;
        if(validator.validateDeckungsumfang(abfrage)){
            for (Deckungsumfang d:firma.getDeckungsumfangList()) {
                if(abfrage.getDeckungsumfang().equals(d.getBezeichnung())){
                    deckungbeitrag=d.getBeitrag();
                    break;
                }
            }
        }
        return deckungbeitrag*basisBeitrag;
    }

    private String getAge(Abfrage abfrage) {
        int age = Integer.parseInt(abfrage.getAge());

        if (age < 25) return "Unter 25";
        if (age >= 25 && age < 50) return "25-50";
        if (age >= 50) return "Über 50";
        return null;
    }

    private String getPostZahl(Abfrage abfrage) {
        try {
            int pz = Integer.valueOf(abfrage.getPostzahl());
            if (pz >= 10000 && pz < 30000) return "1";
            if (pz >= 30000 && pz < 60000) return "2";
            if (pz >= 60000 && pz < 100000) return "3";
            return null; // Geçersiz postzahl durumu
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Postzahl muss digit number haben");
        }
    }

    //mit dieser Methode runden wir Float-Daten
    private float round(float value) {
        return Math.round(value * 100.0f) / 100.0f;
    }

    //mit dieser Methode können wir auf die Informationen einer beliebigen ID zugreifen
    public Angebot findeDurchId(int id) {
        return rechnungRepsitory.findeDurchId(id);
    }
}