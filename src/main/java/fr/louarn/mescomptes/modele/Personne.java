package fr.louarn.mescomptes.modele;

import lombok.*;

import javax.persistence.*;
import java.util.List;

// Lombok annotations
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
// JPA annotations
@Entity
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tb_sequence")
    private Integer id;

    private String nom;

    private String prenom;

    @ManyToOne
    private Civilite civilite;

    @OneToMany
    private List<Compte> comptes;

    @ManyToMany
    private List<Banque> banques;

    @ManyToMany
    private List<Personne> beneficiaires;

}
