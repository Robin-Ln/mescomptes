package fr.louarn.dao;

import fr.louarn.dto.OperationDto;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.assertFalse;

public class OperationDaoTest {

    private static final OperationDao operationDao = new OperationDao();

    @Test
    public void testGetOperations() throws IOException, URISyntaxException {
        List<OperationDto> operationsDto = operationDao.getOperations();

        assertFalse(operationsDto.isEmpty());
    }
}
