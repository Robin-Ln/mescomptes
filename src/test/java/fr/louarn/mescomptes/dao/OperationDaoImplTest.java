package fr.louarn.mescomptes.dao;

import fr.louarn.mescomptes.dto.OperationDto;
import org.easymock.EasyMockSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertFalse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OperationDaoImplTest extends EasyMockSupport{

    private List<OperationDto> operationsDto = Arrays.asList(
            OperationDto.builder()
                    .date(Calendar.getInstance())
                    .libelle("Macdo")
                    .montantEur(BigDecimal.valueOf(12.4))
                    .montantFranc(BigDecimal.valueOf(163.3))
                    .build(),
            OperationDto.builder()
                    .date(Calendar.getInstance())
                    .libelle("Kfc")
                    .montantEur(BigDecimal.valueOf(12.4))
                    .montantFranc(BigDecimal.valueOf(163.3))
                    .build()
    );


    @Test
    public void testGetOperations(){
        assertFalse(false);
    }
}
