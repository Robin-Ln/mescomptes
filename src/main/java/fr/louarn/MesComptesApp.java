package fr.louarn;

import fr.louarn.dto.OperationDto;
import lombok.extern.log4j.Log4j;

@Log4j
public class MesComptesApp {

    public static void main(String[] args) {
        log.info(OperationDto.builder()
                .date("14/03/1996")
                .libelle("Macdo")
                .montantEur("12.4")
                .build());

    }

}
