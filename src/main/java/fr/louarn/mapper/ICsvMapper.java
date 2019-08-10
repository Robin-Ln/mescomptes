package fr.louarn.mapper;

import fr.louarn.dto.OperationDto;
import fr.louarn.modele.Operation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ICsvMapper {

    @Mapping(source = "date", target = "date", dateFormat = "dd/MM/yyyy")
    @Mapping(source = "libelle", target = "libelle")
    @Mapping(target = "montantEur", ignore = true)
    @Mapping(target = "montantFranc", ignore = true)
    Operation dtoToModele(OperationDto operationDto);

}
