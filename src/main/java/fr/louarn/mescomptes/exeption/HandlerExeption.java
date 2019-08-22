package fr.louarn.mescomptes.exeption;

import lombok.extern.log4j.Log4j;

@Log4j
public class HandlerExeption {

    void visite(DaoExeption daoExeption){
        log.info("ERROR", daoExeption);
    }

    void visite(TechnicalExeption technicalExeption){
        log.info("ERROR", technicalExeption);
    }

}
