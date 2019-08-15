package fr.louarn.mescomptes.modele;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

// Lombok annotations
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
// JPA annotations
@Entity
public class Montant {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tb_sequence")
    private Integer id;

    @ManyToOne
    private Devise devise;

    private BigDecimal value;

}
