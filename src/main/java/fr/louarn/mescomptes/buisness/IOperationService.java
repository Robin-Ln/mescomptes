package fr.louarn.mescomptes.buisness;

import fr.louarn.mescomptes.dto.OperationDto;
import fr.louarn.mescomptes.exeption.DaoExeption;

import java.util.List;

public interface IOperationService {

    void createOperation(OperationDto operationDto);

    List<OperationDto> getOperations();

    OperationDto getOperation(Integer id) throws DaoExeption;

    void deleteOperation(Integer id);
}
