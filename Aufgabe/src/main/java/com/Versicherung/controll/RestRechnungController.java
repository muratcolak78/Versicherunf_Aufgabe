package com.Versicherung.controll;

import com.Versicherung.model.Abfrage;
import com.Versicherung.model.Angebot;
import com.Versicherung.service.RechnungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestRechnungController {
    // mit diesem Code können wir das mit @Service zum Kontext
    // hinzugefügte rechnungsservice-Objekt aus springcontex abrufen
    @Autowired
    private RechnungService rechnungService;

    // mit den gespeicherten ID-Nummern können wir die gewünschte ID aufrufen
    @GetMapping(path="/beitrag/{id}")
    public Angebot getBeitrag(@PathVariable int id) {
        return rechnungService.findeDurchId(id);
    }
    // mit dieser Methode können wir die Angebote von 5 verschiedenen Unternehmen bei einer beliebigen Abfrage erhalten
    @PostMapping(path="/beitrag-berechnen")
    public List<Angebot> rechnung(@RequestBody Abfrage abfrage){
        return rechnungService.rechnung(abfrage);
    }
}
