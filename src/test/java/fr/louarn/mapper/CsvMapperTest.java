package fr.louarn.mapper;

import fr.louarn.constant.Constant;
import fr.louarn.dto.OperationDto;
import fr.louarn.modele.Devise;
import fr.louarn.modele.Montant;
import fr.louarn.modele.Operation;
import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
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
     *
     * @throws ParseException exption propager lorsque l'on parse la date
     */
    @Test
    public void testMapperOperationDtoToOperation() throws ParseException {
        OperationDto operationDto = OperationDto.builder()
                .date("14/03/1996")
                .libelle("Macdo")
                .montantEur("12.4")
                .montantFranc("163.3")
                .build();

        Operation operation = csvMapper.operationDtoToOperation(operationDto);

        // Test du libellé
        assertEquals(operation.getLibelle(), operationDto.getLibelle());

        // Test de la date
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constant.DATE_FORMAT, Locale.FRANCE);
        calendar.setTime(simpleDateFormat.parse(operationDto.getDate()));

        assertEquals(operation.getDate(), calendar);

        // Test du montant en euro
        assertEquals(operation.getMontantEur().getValue().toString(), operationDto.getMontantEur());
        assertEquals(Devise.EURO, operation.getMontantEur().getDevise());

        // Test du montant en franc
        assertEquals(operation.getMontantFranc().getValue().toString(), operationDto.getMontantFranc());
        assertEquals(Devise.FRANC, operation.getMontantFranc().getDevise());
    }

    @Test
    public void testMapperOperationToOperationFto() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constant.DATE_FORMAT, Locale.FRANCE);
        calendar.setTime(simpleDateFormat.parse("14/03/1996"));

        Operation operation = Operation
                .builder()
                .date(calendar)
                .libelle("Macdo")
                .montantEur(Montant
                        .builder()
                        .devise(Devise.EURO)
                        .value(BigDecimal.valueOf(12.4))
                        .build())
                .montantFranc(Montant
                        .builder()
                        .devise(Devise.FRANC)
                        .value(BigDecimal.valueOf(163.3))
                        .build())
                .build();

        OperationDto operationDto = csvMapper.operationToOperationDto(operation);

        // Test du libellé
        assertEquals(operation.getLibelle(), operationDto.getLibelle());

        // Test de la date
        String formatedDate = new SimpleDateFormat(Constant.DATE_FORMAT).format(calendar.getTime());
        assertEquals(operationDto.getDate(), formatedDate);

        // Test du montant en euro
        String eurMontant = new DecimalFormat(Constant.BIG_DECIMAL_FORMAT)
                .format(operation.getMontantEur().getValue());
        assertEquals(operationDto.getMontantEur(), eurMontant);

        // Test du montant en franc
        String francMontant = new DecimalFormat(Constant.BIG_DECIMAL_FORMAT)
                .format(operation.getMontantFranc().getValue());
        assertEquals(operationDto.getMontantFranc(), francMontant);
    }
}
