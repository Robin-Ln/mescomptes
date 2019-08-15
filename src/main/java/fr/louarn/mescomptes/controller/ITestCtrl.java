package fr.louarn.mescomptes.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "API pour es opérations CRUD sur les produits.")
@RequestMapping(value = "test")
public interface ITestCtrl {

    @ApiOperation(value = "Récupère un produit grâce à son ID à condition que celui-ci soit en stock!")
    @GetMapping(value = "test")
    ResponseEntity<String> test();
}
