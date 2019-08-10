package fr.louarn.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class OperationDto {

    private String date;

    private String libelle;

    private String montantEur;

    private String montantFranc;

}
