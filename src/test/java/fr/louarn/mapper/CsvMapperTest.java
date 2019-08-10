package fr.louarn.mapper;

import fr.louarn.constant.Constant;
import fr.louarn.dto.OperationDto;
import fr.louarn.modele.Devise;
import fr.louarn.modele.Operation;
import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

@Log4j
public class CsvMapperTest {

    private static ICsvMapper csvMapper = new ICsvMapperImpl();

    /**
     * Test de la converstion d'un objet OperationDto en Operation
     * @throws ParseException exption propager lorsque l'on parse la date
     */
    @Test
    public void dtoToModele() throws ParseException {
        OperationDto operationDto = OperationDto.builder()
                .date("14/03/1996")
                .libelle("Macdo")
                .montantEur(BigDecimal.valueOf(12.4))
                .montantFranc(BigDecimal.valueOf(163.3))
                .build();

        Operation operation = csvMapper.operationDtoToOperation(operationDto);

        // Test du libellé
        assertEquals(operation.getLibelle(), operationDto.getLibelle());

        // Test de la date
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constant.DATE_FORMAT.getValue(), Locale.FRANCE);
        calendar.setTime(simpleDateFormat.parse(operationDto.getDate()));

        assertEquals(operation.getDate(), calendar);

        // Test du montant en euro
        assertEquals(operation.getMontantEur().getValue(), operationDto.getMontantEur());
        assertEquals(Devise.EURO, operation.getMontantEur().getDevise());

        // Test du montant en franc
        assertEquals(operation.getMontantFranc().getValue(), operationDto.getMontantFranc());
        assertEquals(Devise.FRANC, operation.getMontantFranc().getDevise());
    }
}
