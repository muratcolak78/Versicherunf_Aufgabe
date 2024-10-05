package com.Versicherung.config;

import com.Versicherung.model.Abfrage;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    public boolean validateVersicherungsart(Abfrage abfrage) {
        if (abfrage.getVersicherunsgsart().equalsIgnoreCase("Haus") ||
                abfrage.getVersicherunsgsart().equalsIgnoreCase("Auto") ||
                abfrage.getVersicherunsgsart().equalsIgnoreCase("Gesundheit")) {
            return true;
        }
        throw new IllegalArgumentException("Ungültig Versicherungstype!");
    }

    public boolean validateAge(Abfrage abfrage) {
        try {
            int age = Integer.parseInt(abfrage.getAge());
            if (age > 0 && age < 130) {
                return true;
            }
            throw new IllegalArgumentException("Alter muss zwischen 0 und 130 sein!");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Alter muss gültig sein!");
        }
    }

    public boolean validatePostZahl(Abfrage abfrage) {
        try {
            int postzahl = Integer.parseInt(abfrage.getPostzahl()); // Postzahl'ı buradan al
            if (postzahl >= 10000 && postzahl < 100000) {
                return true;
            }
            throw new IllegalArgumentException("Ungültig Postzahl");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Postzahl muss digit number haben!");
        }
    }

    public boolean validateDeckungsumfang(Abfrage abfrage) {
        if (abfrage.getDeckungsumfang().equalsIgnoreCase("Basis") ||
                abfrage.getDeckungsumfang().equalsIgnoreCase("Premium") ||
                abfrage.getDeckungsumfang().equalsIgnoreCase("VIP")) {
            return true;
        }
        throw new IllegalArgumentException("Ungültig Deckungsumfang");
    }
}
