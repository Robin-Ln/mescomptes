package fr.louarn.modele;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Montant {

    private Devise devise;

    private BigDecimal value;

}
