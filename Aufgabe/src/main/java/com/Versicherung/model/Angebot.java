package com.Versicherung.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Angebot {
private int id;
private String firmaName;
private String versicherung;
private float beitrag;
private Detail detail;
}
