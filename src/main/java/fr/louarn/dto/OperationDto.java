package fr.louarn.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class OperationDto {

    @CsvBindByName(column = "Date", required = true)
    private String date;

    @CsvBindByName(column = "Libelle", required = true)
    private String libelle;

    @CsvBindByName(column = "MontantEUROS", required = true)
    private String montantEur;

    @CsvBindByName(column = "MontantFRANCS", required = true)
    private String montantFranc;

}
