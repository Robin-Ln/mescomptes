package fr.louarn.mapper;

import fr.louarn.dto.OperationDto;
import fr.louarn.modele.Devise;
import fr.louarn.modele.Montant;
import fr.louarn.modele.Operation;
import org.mapstruct.Mapper;

import java.math.BigDecimal;

@Mapper
public interface ICsvMapper {

    OperationDto modeleToDto(Operation operation);

    Operation dtoToModele(OperationDto operationDto);


    private Montant getEurMontant(BigDecimal valeur) {
        return Montant
                .builder()
                .devise(Devise.EUR)
                .valeur(valeur)
                .build();
    }


}
