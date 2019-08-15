package fr.louarn.mescomptes.buisness;

import fr.louarn.mescomptes.dto.DeviseDto;
import fr.louarn.mescomptes.exeption.DaoExeption;

import java.util.List;


public interface IDeviseService {

    /**
     *
     * @param deviseDto
     */
    void createDevise(DeviseDto deviseDto);

    /**
     *
     * @return
     */
    List<DeviseDto> getDevises();

    /**
     *
     * @param code
     * @return
     * @throws DaoExeption
     */
    DeviseDto getDevise(String code) throws DaoExeption;

    /**
     *
     * @param code
     * @throws DaoExeption
     */
    void deleteDevise(String code) throws DaoExeption;
}
