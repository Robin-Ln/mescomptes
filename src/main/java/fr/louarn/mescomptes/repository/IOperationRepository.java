package fr.louarn.mescomptes.repository;

import fr.louarn.mescomptes.modele.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface IOperationRepository extends JpaRepository<Operation, Integer> {

    /**
     *
     * @param id
     * @return
     */
    Optional<Operation> findById(Integer id);

    /**
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     *
     * @param id
     * @return
     */
    boolean existsById(Integer id);

}
