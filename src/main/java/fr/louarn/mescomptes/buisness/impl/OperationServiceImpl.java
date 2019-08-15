package fr.louarn.mescomptes.buisness.impl;

import fr.louarn.mescomptes.buisness.IOperationService;
import fr.louarn.mescomptes.dto.OperationDto;
import fr.louarn.mescomptes.exeption.DaoExeption;
import fr.louarn.mescomptes.mapper.OperationMapper;
import fr.louarn.mescomptes.modele.Operation;
import fr.louarn.mescomptes.repository.IOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperationServiceImpl implements IOperationService {

    private OperationMapper operationMapper;

    private IOperationRepository operationRepository;

    @Autowired
    public OperationServiceImpl(OperationMapper operationMapper, IOperationRepository operationRepository) {
        this.operationMapper = operationMapper;
        this.operationRepository = operationRepository;
    }

    @Override
    public void createOperation(OperationDto operationDto) {
        Operation operation = operationMapper.operationDtoToOperation(operationDto);
        operationRepository.save(operation);
    }

    @Override
    public List<OperationDto> getOperations() {
        return operationRepository
                .findAll()
                .stream()
                .map(operation -> operationMapper.operationToOperationDto(operation))
                .collect(Collectors.toList());
    }

    @Override
    public OperationDto getOperation(Integer id) throws DaoExeption {
        Operation operation = operationRepository
                .findById(id)
                .orElseThrow(DaoExeption::new);
        return operationMapper.operationToOperationDto(operation);
    }

    @Override
    public void deleteOperation(Integer id) {
        Operation operation = operationRepository
                .findById(id)
                .orElseThrow(DaoExeption::new);
        return operationMapper.operationToOperationDto(operation);
    }
}
