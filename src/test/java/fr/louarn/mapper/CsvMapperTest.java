package fr.louarn.mapper;

import fr.louarn.dto.OperationDto;
import fr.louarn.modele.Operation;
import org.junit.Test;

import java.math.BigDecimal;

public class CsvMapperTest {

    private static ICsvMapper CsvMapper = new ICsvMapperImpl();

    @Test
    public void modeleToDto() {
    }

    @Test
    public void dtoToModele() {
        OperationDto operationDto = OperationDto.builder()
                .date("14/03/1996")
                .libelle("Macdo")
                .montantEur(BigDecimal.valueOf(12.4))
                .build();

        Operation operation = CsvMapper.dtoToModele(operationDto);
    }
}
