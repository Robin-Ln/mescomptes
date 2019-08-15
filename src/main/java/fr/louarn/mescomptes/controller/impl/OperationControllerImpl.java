package fr.louarn.mescomptes.controller.impl;

import fr.louarn.mescomptes.buisness.IOperationService;
import fr.louarn.mescomptes.controller.IOperationController;
import fr.louarn.mescomptes.dto.OperationDto;
import fr.louarn.mescomptes.exeption.DaoExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OperationControllerImpl implements IOperationController {

    private IOperationService operationService;

    @Autowired
    public OperationControllerImpl(IOperationService operationService) {
        this.operationService = operationService;
    }

    @Override
    public ResponseEntity<Void> createOperation(OperationDto operationDto) {
        operationService.createOperation(operationDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<OperationDto>> getOperations() {
        List<OperationDto> operationsDto = operationService.getOperations();
        return new ResponseEntity<>(operationsDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OperationDto> getOperation(Integer id) {
        OperationDto operationDto = null;
        try {
            operationDto = operationService.getOperation(id);
        } catch (DaoExeption daoExeption) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(operationDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteOperation(Integer id) {
        try {
            operationService.deleteOperation(id);
        } catch (DaoExeption daoExeption) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
