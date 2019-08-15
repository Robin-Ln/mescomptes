package fr.louarn.mescomptes.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface IMapper<E, D> {

    E dtoToEntity(D dto);

    D entityToDto(E entity);

    default List<E> dtoToEntity(List<D> dto) {
        return dto
                .stream()
                .map(this::dtoToEntity)
                .collect(Collectors.toList());
    }

    default List<D> entityToDto(List<E> entity) {
        return entity
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

}
