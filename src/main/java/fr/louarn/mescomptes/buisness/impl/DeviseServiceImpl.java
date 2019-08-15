package fr.louarn.mescomptes.buisness.impl;

import fr.louarn.mescomptes.buisness.IDeviseService;
import fr.louarn.mescomptes.dto.DeviseDto;
import fr.louarn.mescomptes.exeption.DaoExeption;
import fr.louarn.mescomptes.mapper.DeviseMapper;
import fr.louarn.mescomptes.modele.Devise;
import fr.louarn.mescomptes.repository.IDeviseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviseServiceImpl implements IDeviseService {

    @Autowired
    private DeviseMapper deviseMapper;

    @Autowired
    IDeviseRepository deviseRepository;

    @Override
    public void createDevise(DeviseDto deviseDto) {
        Devise devise = deviseMapper.dtoToEntity(deviseDto);
        deviseRepository.save(devise);
    }

    @Override
    public List<DeviseDto> getDevises() {
        List<Devise> devises = deviseRepository.findAll();
        return deviseMapper.entityToDto(devises);
    }

    @Override
    public DeviseDto getDevise(String code) throws DaoExeption {
        Devise operation = deviseRepository
                .findByCode(code)
                .orElseThrow(DaoExeption::new);
        return deviseMapper.entityToDto(operation);
    }

    @Override
    public void deleteDevise(String code) throws DaoExeption {
        if (deviseRepository.existsByCode(code)) {
            deviseRepository.deleteByCode(code);
        } else {
            throw new DaoExeption();
        }
    }
}
