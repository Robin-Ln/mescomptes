package fr.louarn.mescomptes.buisness;

import fr.louarn.mescomptes.dto.DeviseDto;
import fr.louarn.mescomptes.exeption.DaoExeption;

import java.util.List;


public interface IDeviseService {

    /**
     * Création d'une devise
     * @param deviseDto dto représentent une devise
     */
    void createDevise(DeviseDto deviseDto);

    /**
     * Récupère toutes les devises
     * @return
     */
    List<DeviseDto> getDevises();

    /**
     * Récupère une devise en fonction de sont code
     * @param code code d'une devise
     * @return Dto représentant une devise
     * @throws DaoExeption si on ne trouve pas la devise on propage une exection
     */
    DeviseDto getDevise(String code) throws DaoExeption;

    /**
     * Supprime devise en fonction de sont code
     * @param code code d'une devise
     * @throws DaoExeption si on ne trouve pas la devise on propage une exection
     */
    void deleteDevise(String code) throws DaoExeption;
}
