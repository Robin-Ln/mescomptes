package fr.louarn.mescomptes.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Calendar;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class OperationDto {

    private Integer id;

    private Calendar date;

    private String libelle;

    private BigDecimal montantEur;

    private BigDecimal montantFranc;

}
