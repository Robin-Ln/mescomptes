package fr.louarn.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Devise {

    EUR("euro"),
    FRANC("franc");

    private String name;

}
