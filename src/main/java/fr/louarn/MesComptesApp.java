package fr.louarn;

import fr.louarn.dto.OperationDto;

import java.math.BigDecimal;

public class MesComptesApp {

    public static void main(String[] args) {
        System.out.println("test");
        OperationDto.builder()
                .date("14/03/1996")
                .libelle("Macdo")
                .montantEur(BigDecimal.valueOf(12.4))
                .build();
    }

}
