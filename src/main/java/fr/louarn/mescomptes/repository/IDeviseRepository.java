package fr.louarn.mescomptes.repository;

import fr.louarn.mescomptes.modele.Devise;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface IDeviseRepository extends JpaRepository<Devise, String> {

    /**
     *
     * @param code
     * @return
     */
    Optional<Devise> findByCode(String code);

    /**
     *
     * @param code
     */
    void deleteByCode(String code);

    /**
     *
     * @param code
     * @return
     */
    boolean existsByCode(String code);
}
