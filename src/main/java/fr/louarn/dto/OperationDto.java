package fr.louarn.dto;

import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class OperationDto {

    @CsvBindByPosition(position = 0)
    private String date;

    @CsvBindByPosition(position = 1)
    private String libelle;

    @CsvBindByPosition(position = 2)
    private String montantEur;

    @CsvBindByPosition(position = 3)
    private String montantFranc;

}
