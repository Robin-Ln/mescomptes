package fr.louarn.mescomptes.modele;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
public class Banque {

    @Id
    private String code;

    private String libelle;

    @OneToMany
    List<Compte> comptes;

    @ManyToMany
    List<Personne> clients;

}
