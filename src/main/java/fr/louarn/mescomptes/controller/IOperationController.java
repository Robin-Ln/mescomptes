package fr.louarn.mescomptes.controller;


import fr.louarn.mescomptes.dto.OperationDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Action de base sur une opérations")
@RequestMapping(path = "/operation")
public interface IOperationController {

    @ApiOperation(value = "Permet la création d'une opération")
    @PostMapping
    ResponseEntity<Void> createOperation(OperationDto operationDto);

    @ApiOperation(value = "Permet la récupération de toutes les opérations")
    @GetMapping
    ResponseEntity<List<OperationDto>> getOperations();

    @ApiOperation(value = "Permet la récupération d'une opérations en fonction de son identifiant")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Opération récupéré avec succes"),
            @ApiResponse(code = 404, message = "L'opération n'existe pas")
    })
    @GetMapping(path = "/id/{id}")
    ResponseEntity<OperationDto> getOperation(@PathVariable Integer id);

    @ApiOperation(value = "Permet la suppression d'une opérations en fonction de son identifiant")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Opération supprimer"),
            @ApiResponse(code = 404, message = "L'pération n'existe pas")
    })
    @DeleteMapping(path = "/id/{id}")
    ResponseEntity<Void> deleteOperation(@PathVariable Integer id);

}
