package fr.louarn.modele;

import lombok.Getter;

@Getter
public enum Devise {

    EUR("euro"),
    FRANC("franc");

    private String name;

    Devise(String name) {
        this.name = name;
    }
}
