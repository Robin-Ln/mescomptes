package fr.louarn.mescomptes.mapper;


import fr.louarn.mescomptes.constant.Constant;
import fr.louarn.mescomptes.dto.OperationDto;
import fr.louarn.mescomptes.modele.Devise;
import fr.louarn.mescomptes.modele.Montant;
import fr.louarn.mescomptes.modele.Operation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface OperationMapper {

    @Mapping(target = "id", ignore = true)
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
                .devise(Devise
                        .builder()
                        .code("EURO")
                        .libelle("euro")
                        .build())
                .build();
    }

    @Named("createFrancMontant")
    default Montant createFrancMontant(String value) {
        BigDecimal bigDecimal = BigDecimal.valueOf(Double.parseDouble(value));
        return Montant
                .builder()
                .value(bigDecimal)
                .devise(Devise
                        .builder()
                        .code("FRANC")
                        .libelle("franc")
                        .build())
                .build();
    }

}
