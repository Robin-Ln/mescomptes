package fr.louarn.mapper;

import fr.louarn.constant.Constant;
import fr.louarn.dto.OperationDto;
import fr.louarn.modele.Devise;
import fr.louarn.modele.Montant;
import fr.louarn.modele.Operation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;

@Mapper
public interface ICsvMapper {

    @Mapping(source = "date", target = "date", dateFormat = Constant.DATE_FORMAT)
    @Mapping(source = "libelle", target = "libelle")
    @Mapping(source = "montantEur", qualifiedByName = "createEurMontant", target = "montantEur")
    @Mapping(source = "montantFranc", qualifiedByName = "createFrancMontant", target = "montantFranc")
    Operation operationDtoToOperation(OperationDto operationDto);

    @Mapping(source = "date", target = "date", dateFormat = Constant.DATE_FORMAT)
    @Mapping(source = "libelle", target = "libelle")
    @Mapping(source = "montantEur.value", target = "montantEur", numberFormat = Constant.BIG_DECIMAL_FORMAT)
    @Mapping(source = "montantFranc.value", target = "montantFranc", numberFormat = Constant.BIG_DECIMAL_FORMAT)
    OperationDto operationToOperationDto(Operation operation);


    @Named("createEurMontant")
    default Montant createEurMontant(String value) {
        BigDecimal bigDecimal = BigDecimal.valueOf(Double.parseDouble(value));
        return Montant
                .builder()
                .value(bigDecimal)
                .devise(Devise.EURO)
                .build();
    }

    @Named("createFrancMontant")
    default Montant createFrancMontant(String value) {
        BigDecimal bigDecimal = BigDecimal.valueOf(Double.parseDouble(value));
        return Montant
                .builder()
                .value(bigDecimal)
                .devise(Devise.FRANC)
                .build();
    }

}
