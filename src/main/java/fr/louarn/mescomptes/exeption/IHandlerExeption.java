package fr.louarn.mescomptes.exeption;

import org.springframework.stereotype.Component;

@Component
public interface IHandlerExeption {

    void visite(DaoExeption daoExeption);

    void visite(TechnicalExeption technicalExeption);

}
