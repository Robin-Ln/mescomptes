package fr.louarn;

import fr.louarn.dto.OperationDto;

public class MesComptesApp {

    public static void main(String[] args) {
        System.out.println("test");
        OperationDto operationDto = OperationDto.builder()
                .date("14/03/1996")
                .libelle("Macdo")
                .montantEur("12.4")
                .montantFranc("123.7")
                .build();
    }

}
