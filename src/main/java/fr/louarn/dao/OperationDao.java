package fr.louarn.dao;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import fr.louarn.dto.OperationDto;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OperationDao {
    private static final String SAMPLE_CSV_FILE_PATH = "/1027012P0341565451753399.csv";

    List<OperationDto> getOperations() throws IOException, URISyntaxException {

        Reader reader = Files.newBufferedReader(Paths.get(getClass().getResource(SAMPLE_CSV_FILE_PATH).toURI()));

        CsvToBean<OperationDto> csvToBean = new CsvToBeanBuilder<OperationDto>(reader)
                .withType(OperationDto.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        return csvToBean.parse();

    }
}
