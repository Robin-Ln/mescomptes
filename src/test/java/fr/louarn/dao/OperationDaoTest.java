package fr.louarn.dao;

import fr.louarn.dto.OperationDto;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class OperationDaoTest {

    private OperationDao operationDao = createMock(OperationDao.class);


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
    public void testGetOperations() throws IOException, URISyntaxException {

        expect(operationDao.getOperations()).andReturn(this.operationsDto);
        replay(operationDao);

        verify();

        List<OperationDto> operationsDto = operationDao.getOperations();

        assertEquals(operationsDto.size(), this.operationsDto.size());
        assertFalse(operationsDto.isEmpty());
    }
}
