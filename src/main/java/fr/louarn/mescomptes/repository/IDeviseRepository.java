package fr.louarn.mescomptes.repository;

import fr.louarn.mescomptes.modele.Devise;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface IDeviseRepository extends JpaRepository<Devise, String> {

    Optional<Devise> findByCode(String code);

    @Transactional()
    void deleteByCode(String code);

    boolean existsByCode(String code);
}
