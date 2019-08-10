package fr.louarn.mapper;

import fr.louarn.dto.OperationDto;
import fr.louarn.modele.Operation;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CsvMapperTest {

    private static ICsvMapper csvMapper = new ICsvMapperImpl();

    @Test
    public void dtoToModele() {
        OperationDto operationDto = OperationDto.builder()
                .date("14/03/1996")
                .libelle("Macdo")
                .montantEur(BigDecimal.valueOf(12.4))
                .build();

        Operation operation = csvMapper.dtoToModele(operationDto);

        Assert.assertEquals(operation.getLibelle(), operationDto.getLibelle());
    }
}
