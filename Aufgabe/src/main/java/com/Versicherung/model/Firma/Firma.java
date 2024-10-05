package com.Versicherung.model.Firma;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Firma {
    private String firmaName;
    private List<Versicherungsart> versicherungsartList;
    private List<Alter> alterList;
    private List<Postzahl> postzahlList;
    private List<Deckungsumfang> deckungsumfangList;

}
