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
public abstract class OperationMapper implements IMapper<Operation, OperationDto> {


    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "date", target = "date")
    @Mapping(source = "libelle", target = "libelle")
    @Mapping(source = "montantEur", qualifiedByName = "createEurMontant", target = "montantEur")
    @Mapping(source = "montantFranc", qualifiedByName = "createFrancMontant", target = "montantFranc")
    public abstract Operation dtoToEntity(OperationDto operationDto);


    @Override
    @Mapping(source = "date", target = "date")
    @Mapping(source = "libelle", target = "libelle")
    @Mapping(source = "montantEur.value", target = "montantEur", numberFormat = Constant.BIG_DECIMAL_FORMAT)
    @Mapping(source = "montantFranc.value", target = "montantFranc", numberFormat = Constant.BIG_DECIMAL_FORMAT)
    public abstract OperationDto entityToDto(Operation operation);


    @Named("createEurMontant")
    Montant createEurMontant(String value) {
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
    Montant createFrancMontant(String value) {
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
