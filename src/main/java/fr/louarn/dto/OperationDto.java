package fr.louarn.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class OperationDto {

    private String date;

    private String libelle;

    private BigDecimal montantEur;

    private BigDecimal montantFranc;

}
