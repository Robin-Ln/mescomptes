package fr.louarn.mescomptes.controller.impl;

import fr.louarn.mescomptes.buisness.IDeviseService;
import fr.louarn.mescomptes.buisness.IOperationService;
import fr.louarn.mescomptes.controller.IDeviseController;
import fr.louarn.mescomptes.dto.DeviseDto;
import fr.louarn.mescomptes.exeption.DaoExeption;
import fr.louarn.mescomptes.exeption.IHandlerExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeviseControllerImpl implements IDeviseController {

    IDeviseService deviseService;

    IHandlerExeption handlerExeption;

    @Autowired
    public DeviseControllerImpl(IDeviseService deviseService, IHandlerExeption handlerExeption) {
        this.deviseService = deviseService;
        this.handlerExeption = handlerExeption;
    }

    @Override
    public ResponseEntity<Void> createDevise(DeviseDto deviseDto) {
        deviseService.createDevise(deviseDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DeviseDto>> getDevises() {
        List<DeviseDto> devisesDto = deviseService.getDevises();
        return new ResponseEntity<>(devisesDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DeviseDto> getDevise(String code) {
        try {
            DeviseDto deviseDto = deviseService.getDevise(code);
            return new ResponseEntity<>(deviseDto, HttpStatus.OK);
        } catch (DaoExeption daoExeption) {
            daoExeption.accept(handlerExeption);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deleteDevise(String code) {
        try {
            deviseService.deleteDevise(code);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DaoExeption daoExeption) {
            daoExeption.accept(handlerExeption);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
