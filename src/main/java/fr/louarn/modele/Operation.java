package fr.louarn.modele;

import lombok.*;

import java.util.Calendar;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Operation {

    private Calendar date;

    private String libelle;

    private Montant montantEur;

    private Montant montantFranc;

}
