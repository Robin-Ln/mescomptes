package fr.louarn.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Devise {

    EURO("euro"),
    FRANC("franc");

    private String name;

}
