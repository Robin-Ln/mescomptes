package fr.louarn.dao;

import fr.louarn.dto.OperationDto;
import org.easymock.EasyMockSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OperationDaoImplTest extends EasyMockSupport{

    private List<OperationDto> operationsDto = Arrays.asList(
            OperationDto.builder()
                    .date("14/03/1996")
                    .libelle("Macdo")
                    .montantEur("12.4")
                    .montantFranc("163.3")
                    .build(),
            OperationDto.builder()
                    .date("14/03/1996")
                    .libelle("Kfc")
                    .montantEur("18.4")
                    .montantFranc("203.3")
                    .build()
    );


    @Test
    public void testGetOperations(){
        assertFalse(false);
    }
}
