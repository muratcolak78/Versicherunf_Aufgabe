package com.Versicherung.repository;


import com.Versicherung.model.Firma.Firma;
import com.Versicherung.model.Angebot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RechnungRepsitory {
    // mit diesem Code kann die Angebotsliste von contex aufgerufen werden
    @Autowired
    private List<Angebot> angebotListe;
    // Firmaliste kann notwendig sein, von contex aus Datenbankinformationen an die Serviceklasse zu senden
    @Autowired
    private List<Firma> firmaListe;

    //mit dieser Methode können wir Abfragen in der Angebotliste im Kontext speichern.
    public void speichern(Angebot angebot) {
        angebotListe.add(angebot);
    }
    //Mit dieser Methode stellen wir der Serviceklasse die Firmenliste zur Verfügung,
    // damit sie ein Angebot entsprechend der Firma berechnen kann
    public List<Firma> getFirmaliste(){
        return firmaListe;
    }
 // mit dieser Methode kann das für die gewünschte ID-Nummer registrierte Angebot angezeigt werden
    public Angebot findeDurchId(int id) {
        Angebot angebot=null;
        for (Angebot a:angebotListe) {
            if(id==a.getId()){
                angebot=a;
                break;
            }
        }
        return angebot;
    }

}