package fr.louarn.mescomptes.modele;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigInteger;

// Lombok annotations
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
// JPA annotations
@Entity
public class Compte {

    @Id
    private BigInteger numero;

    @ManyToOne
    private TypeCompte typeCompte;

    @ManyToOne
    private Personne personne;

    @ManyToOne
    private Banque banque;

}
