package fr.louarn.mescomptes.repository;

import fr.louarn.mescomptes.modele.Montant;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IMontantRepository extends JpaRepository<Montant, Integer> {
}
