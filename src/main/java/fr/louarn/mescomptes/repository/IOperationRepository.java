package fr.louarn.mescomptes.repository;

import fr.louarn.mescomptes.modele.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;


public interface IOperationRepository extends JpaRepository<Operation, Integer> {

    Optional<Operation> findById(Integer id);

    @Transactional
    void deleteById(Integer id);

    boolean existsById(Integer id);

}
