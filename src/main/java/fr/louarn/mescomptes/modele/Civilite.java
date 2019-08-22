package fr.louarn.mescomptes.modele;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

// Lombok annotations
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
// JPA annotations
@Entity
public class Civilite {

    @Id
    private String code;

    private String libelle;

}

