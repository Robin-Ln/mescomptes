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
    public void testMapperOperationDtoToOperation() {
        OperationDto operationDto = OperationDto
                .builder()
                .date(Calendar.getInstance())
                .libelle("Macdo")
                .montantEur(BigDecimal.valueOf(12.4))
                .montantFranc(BigDecimal.valueOf(163.3))
                .build();

        Operation operation = operationMapper.dtoToEntity(operationDto);

        // Test du libellé
        assertEquals(operation.getLibelle(), operationDto.getLibelle());

        // Test de la date
        assertEquals(operation.getDate(), operationDto.getDate());

        // Test du montant en euro
        assertEquals(operation.getMontantEur().getValue(), operationDto.getMontantEur());
        assertEquals(Devise.builder().code("EURO").libelle("euro").build(), operation.getMontantEur().getDevise());

        // Test du montant en franc
        assertEquals(operation.getMontantFranc().getValue(), operationDto.getMontantFranc());
        assertEquals(Devise.builder().code("FRANC").libelle("franc").build(), operation.getMontantFranc().getDevise());
    }

    @Test
    public void testMapperOperationToOperationDto() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constant.DATE_FORMAT, Locale.FRANCE);
        calendar.setTime(simpleDateFormat.parse("14/03/1996"));

        Operation operation = Operation
                .builder()
                .id(1)
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

        OperationDto operationDto = operationMapper.entityToDto(operation);

        // Test de l'id
        assertEquals(operation.getId(), operationDto.getId());

        // Test du libellé
        assertEquals(operation.getLibelle(), operationDto.getLibelle());

        // Test de la date
        assertEquals(operationDto.getDate(), operation.getDate());

        // Test du montant en euro
        assertEquals(operationDto.getMontantEur(), operation.getMontantEur().getValue());

        // Test du montant en franc
        assertEquals(operationDto.getMontantFranc(), operation.getMontantFranc().getValue());
    }
}
