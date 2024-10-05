package com.Versicherung.config;

import com.Versicherung.model.Firma.*;
import com.Versicherung.model.Angebot;
import com.Versicherung.model.Firma.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public List<Angebot> angebotList(){
        List<Angebot> angebotListe=new ArrayList<>();
        return angebotListe;
    }

    @Bean
    public List<Firma> firmaList() {
        List<Firma> firmaListe = new ArrayList<>();

        firmaListe.add(new Firma("Firma A",
                new ArrayList<Versicherungsart>() {{
                    add(new Versicherungsart("Auto", 50));
                    add(new Versicherungsart("Haus", 40));
                    add(new Versicherungsart("Gesundheit", 60));
                }},
                new ArrayList<Alter>() {{
                    add(new Alter("Unter 25", 0.2f));
                    add(new Alter("25-50", 0.1f));
                    add(new Alter("Über 50", 0.05f));
                }},
                new ArrayList<Postzahl>() {{
                    add(new Postzahl("1", 0.1f));
                    add(new Postzahl("3", 0.05f));
                    add(new Postzahl("6", 0f));
                }},
                new ArrayList<Deckungsumfang>() {{
                    add(new Deckungsumfang("Basis", 0f));
                    add(new Deckungsumfang("Premium", 0.15f));
                    add(new Deckungsumfang("VIP", 0.30f));
                }}
        ));

        firmaListe.add(new Firma("Firma B",
                new ArrayList<Versicherungsart>() {{
                    add(new Versicherungsart("Auto", 45));
                    add(new Versicherungsart("Haus", 38));
                    add(new Versicherungsart("Gesundheit", 58));
                }},
                new ArrayList<Alter>() {{
                    add(new Alter("Unter 25", 0.18f));
                    add(new Alter("25-50", 0.08f));
                    add(new Alter("Über 50", 0.06f));
                }},
                new ArrayList<Postzahl>() {{
                    add(new Postzahl("1", 0.12f));
                    add(new Postzahl("3", 0.03f));
                    add(new Postzahl("6", 0.00f));
                }},
                new ArrayList<Deckungsumfang>() {{
                    add(new Deckungsumfang("Basis", 0.00f));
                    add(new Deckungsumfang("Premium", 0.11f));
                    add(new Deckungsumfang("VIP", 0.27f));
                }}
        ));

        firmaListe.add(new Firma("Firma C",
                new ArrayList<Versicherungsart>() {{
                    add(new Versicherungsart("Auto", 55));
                    add(new Versicherungsart("Haus", 42));
                    add(new Versicherungsart("Gesundheit", 62));
                }},
                new ArrayList<Alter>() {{
                    add(new Alter("Unter 25", 0.22f));
                    add(new Alter("25-50", 0.12f));
                    add(new Alter("Über 50", 0.07f));
                }},
                new ArrayList<Postzahl>() {{
                    add(new Postzahl("1", 0.11f));
                    add(new Postzahl("3", 0.04f));
                    add(new Postzahl("6", 0.00f));
                }},
                new ArrayList<Deckungsumfang>() {{
                    add(new Deckungsumfang("Basis", 0.00f));
                    add(new Deckungsumfang("Premium", 0.20f));
                    add(new Deckungsumfang("VIP", 0.35f));
                }}
        ));

        firmaListe.add(new Firma("Firma D",
                new ArrayList<Versicherungsart>() {{
                    add(new Versicherungsart("Auto", 52));
                    add(new Versicherungsart("Haus", 44));
                    add(new Versicherungsart("Gesundheit", 65));
                }},
                new ArrayList<Alter>() {{
                    add(new Alter("Unter 25", 0.19f));
                    add(new Alter("25-50", 0.09f));
                    add(new Alter("Über 50", 0.04f));
                }},
                new ArrayList<Postzahl>() {{
                    add(new Postzahl("1", 0.13f));
                    add(new Postzahl("3", 0.05f));
                    add(new Postzahl("6", 0.00f));
                }},
                new ArrayList<Deckungsumfang>() {{
                    add(new Deckungsumfang("Basis", 0.00f));
                    add(new Deckungsumfang("Premium", 0.18f));
                    add(new Deckungsumfang("VIP", 0.33f));
                }}
        ));

        firmaListe.add(new Firma("Firma E",
                new ArrayList<Versicherungsart>() {{
                    add(new Versicherungsart("Auto", 48));
                    add(new Versicherungsart("Haus", 39));
                    add(new Versicherungsart("Gesundheit", 61));
                }},
                new ArrayList<Alter>() {{
                    add(new Alter("Unter 25", 0.17f));
                    add(new Alter("25-50", 0.09f));
                    add(new Alter("Über 50", 0.03f));
                }},
                new ArrayList<Postzahl>() {{
                    add(new Postzahl("1", 0.09f));
                    add(new Postzahl("3", 0.04f));
                    add(new Postzahl("6", 0.00f));
                }},
                new ArrayList<Deckungsumfang>() {{
                    add(new Deckungsumfang("Basis", 0.00f));
                    add(new Deckungsumfang("Premium", 0.14f));
                    add(new Deckungsumfang("VIP", 0.28f));
                }}
        ));

        return firmaListe;
    }

}
