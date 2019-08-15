package fr.louarn.mescomptes.modele;

import lombok.*;

import javax.persistence.*;
import java.util.Calendar;

// Lombok annotations
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
// JPA annotations
@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tb_sequence")
    private Integer id;

    private Calendar date;

    private String libelle;

    @OneToOne
    private Montant montantEur;

    @OneToOne
    private Montant montantFranc;

}
