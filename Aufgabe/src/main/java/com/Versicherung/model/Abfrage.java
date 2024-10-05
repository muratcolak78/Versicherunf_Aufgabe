package com.Versicherung.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Abfrage {
    private String versicherunsgsart;
    private String age;
    private String postzahl;
    private String deckungsumfang;
}
