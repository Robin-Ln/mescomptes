package fr.louarn.mescomptes.mapper;


import fr.louarn.mescomptes.constant.Constant;
import fr.louarn.mescomptes.dto.OperationDto;
import fr.louarn.mescomptes.modele.Devise;
import fr.louarn.mescomptes.modele.Montant;
import fr.louarn.mescomptes.modele.Operation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperationMapperTest {

    @Autowired
    private OperationMapper operationMapper;

    @Test
    public void testMapperOperationDtoToOperation() throws ParseException {
        OperationDto operationDto = OperationDto.builder()
                .date("14/03/1996")
                .libelle("Macdo")
                .montantEur("12.4")
                .montantFranc("163.3")
                .build();

        Operation operation = operationMapper.operationDtoToOperation(operationDto);

        // Test du libellé
        assertEquals(operation.getLibelle(), operationDto.getLibelle());

        // Test de la date
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constant.DATE_FORMAT, Locale.FRANCE);
        calendar.setTime(simpleDateFormat.parse(operationDto.getDate()));

        assertEquals(operation.getDate(), calendar);

        // Test du montant en euro
        assertEquals(operation.getMontantEur().getValue().toString(), operationDto.getMontantEur());
        assertEquals(Devise.builder().code("EURO").libelle("euro").build(), operation.getMontantEur().getDevise());

        // Test du montant en franc
        assertEquals(operation.getMontantFranc().getValue().toString(), operationDto.getMontantFranc());
        assertEquals(Devise.builder().code("FRANC").libelle("franc").build(), operation.getMontantFranc().getDevise());
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
                        .devise(Devise
                                .builder()
                                .code("EURO")
                                .libelle("euro")
                                .build())
                        .value(BigDecimal.valueOf(12.4))
                        .build())
                .montantFranc(Montant
                        .builder()
                        .devise(Devise
                                .builder()
                                .code("FRANC")
                                .libelle("franc")
                                .build())
                        .value(BigDecimal.valueOf(163.3))
                        .build())
                .build();

        OperationDto operationDto = operationMapper.operationToOperationDto(operation);

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
