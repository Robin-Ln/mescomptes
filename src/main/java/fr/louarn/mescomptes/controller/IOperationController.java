package fr.louarn.mescomptes.controller;


import fr.louarn.mescomptes.dto.OperationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "operation")
public interface IOperationController {

    @PostMapping
    ResponseEntity<Void> createOperation(OperationDto operationDto);

    @GetMapping
    ResponseEntity<List<OperationDto>> getOperations();

    @GetMapping(path = "id/{id}")
    ResponseEntity<OperationDto> getOperation(@PathVariable Integer id);

    @DeleteMapping(path = "id/{id}")
    ResponseEntity<Void> deleteOperation(@PathVariable Integer id);

}
