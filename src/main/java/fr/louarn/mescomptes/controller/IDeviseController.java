package fr.louarn.mescomptes.controller;

import fr.louarn.mescomptes.dto.DeviseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "/devise", tags = "Devise")
@RequestMapping(path = "/devise")
public interface IDeviseController {

    @ApiOperation(value = "Permet la création d'une devise")
    @PostMapping
    ResponseEntity<Void> createDevise(DeviseDto deviseDto);

    @ApiOperation(value = "Permet la récupération des devises")
    @GetMapping
    ResponseEntity<List<DeviseDto>> getDevises();

    @ApiOperation(value = "Permet la récupération d'une devise en fonction du code")
    @GetMapping(value = "/code/{code}")
    ResponseEntity<DeviseDto> getDevise(@PathVariable String code);

    @ApiOperation(value = "Permet la suppréssion d'une devise en fonction du code")
    @DeleteMapping(value = "/code/{code}")
    ResponseEntity<Void> deleteDevise(@PathVariable String code);

}
