package fr.louarn.mescomptes.buisness.impl;

import fr.louarn.mescomptes.buisness.IOperationService;
import fr.louarn.mescomptes.dto.OperationDto;
import fr.louarn.mescomptes.exeption.DaoExeption;
import fr.louarn.mescomptes.mapper.OperationMapper;
import fr.louarn.mescomptes.modele.Operation;
import fr.louarn.mescomptes.repository.IMontantRepository;
import fr.louarn.mescomptes.repository.IOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationServiceImpl implements IOperationService {

    private OperationMapper operationMapper;

    private IOperationRepository operationRepository;

    private IMontantRepository montantRepository;

    @Autowired
    public OperationServiceImpl(OperationMapper operationMapper,
                                IOperationRepository operationRepository,
                                IMontantRepository montantRepository) {
        this.operationMapper = operationMapper;
        this.operationRepository = operationRepository;
        this.montantRepository = montantRepository;
    }

    @Override
    public void createOperation(OperationDto operationDto) {
        Operation operation = operationMapper.dtoToEntity(operationDto);
        montantRepository.save(operation.getMontantEur());
        montantRepository.save(operation.getMontantFranc());
        operationRepository.save(operation);
    }

    @Override
    public List<OperationDto> getOperations() {
        List<Operation> operations = operationRepository.findAll();
        return operationMapper.entityToDto(operations);
    }

    @Override
    public OperationDto getOperation(Integer id) throws DaoExeption {
        Operation operation = operationRepository
                .findById(id)
                .orElseThrow(DaoExeption::new);
        return operationMapper.entityToDto(operation);
    }

    @Override
    public void deleteOperation(Integer id) throws DaoExeption {
        Operation operation = operationRepository
                .findById(id)
                .orElseThrow(DaoExeption::new);
        montantRepository.deleteById(operation.getMontantEur().getId());
        montantRepository.deleteById(operation.getMontantFranc().getId());
        operationRepository.deleteById(id);
    }
}
