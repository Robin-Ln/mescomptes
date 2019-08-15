package fr.louarn.mescomptes.mapper;


import fr.louarn.mescomptes.dto.DeviseDto;
import fr.louarn.mescomptes.modele.Devise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class DeviseMapper implements IMapper<Devise, DeviseDto> {

    @Override
    @Mapping(source = "code",target = "code")
    @Mapping(source = "libelle",target = "libelle")
    public abstract Devise dtoToEntity(DeviseDto dto);

    @Override
    @Mapping(source = "code",target = "code")
    @Mapping(source = "libelle",target = "libelle")
    public abstract DeviseDto entityToDto(Devise entity);

}
