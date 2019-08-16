package fr.louarn.mescomptes.buisness;

import fr.louarn.mescomptes.dto.OperationDto;
import fr.louarn.mescomptes.exeption.DaoExeption;

import java.util.List;

public interface IOperationService {

    /**
     * Création d'une opération
     * @param operationDto
     */
    void createOperation(OperationDto operationDto);

    /**
     *
     * @return
     */
    List<OperationDto> getOperations();

    /**
     *
     * @param id
     * @return
     * @throws DaoExeption
     */
    OperationDto getOperation(Integer id) throws DaoExeption;

    /**
     *
     * @param id
     * @throws DaoExeption
     */
    void deleteOperation(Integer id) throws DaoExeption;
}
