package fr.louarn.mescomptes.controller.impl;

import fr.louarn.mescomptes.buisness.IOperationService;
import fr.louarn.mescomptes.controller.IOperationController;
import fr.louarn.mescomptes.dto.OperationDto;
import fr.louarn.mescomptes.exeption.DaoExeption;
import fr.louarn.mescomptes.exeption.IHandlerExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OperationControllerImpl implements IOperationController {

    private IOperationService operationService;

    private IHandlerExeption handlerExeption;

    @Autowired
    public OperationControllerImpl(IOperationService operationService, IHandlerExeption handlerExeption) {
        this.operationService = operationService;
        this.handlerExeption = handlerExeption;
    }

    @Override
    public ResponseEntity<Void> createOperation(@RequestBody OperationDto operationDto) {
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
        try {
            OperationDto operationDto = operationService.getOperation(id);
            return new ResponseEntity<>(operationDto, HttpStatus.OK);
        } catch (DaoExeption daoExeption) {
            daoExeption.accept(handlerExeption);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deleteOperation(Integer id) {
        try {
            operationService.deleteOperation(id);
        } catch (DaoExeption daoExeption) {
            daoExeption.accept(handlerExeption);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
