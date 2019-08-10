package fr.louarn.mapper;

import fr.louarn.dto.OperationDto;
import fr.louarn.modele.Devise;
import fr.louarn.modele.Montant;
import fr.louarn.modele.Operation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.math.BigDecimal;

@Mapper
public interface ICsvMapper {

    //OperationDto modeleToDto(Operation operation);

    @Mappings({
            //@Mapping(target = "montantEur", expression = "java(getEurMontant(operationDto.getMontantEur()))")
            @Mapping(target = "date", ignore = true),
            @Mapping(source = "libelle", target = "libelle"),
            @Mapping(target = "montantEur", ignore = true),
            @Mapping(target = "montantFranc", ignore = true)
    })
    Operation dtoToModele(OperationDto operationDto);


    private Montant getEurMontant(BigDecimal valeur) {
        return Montant
                .builder()
                .devise(Devise.EUR)
                .valeur(valeur)
                .build();
    }


}
