package com.Versicherung.model.Firma;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Versicherungsart {
    private String artName;
    private float beitrag;
}
