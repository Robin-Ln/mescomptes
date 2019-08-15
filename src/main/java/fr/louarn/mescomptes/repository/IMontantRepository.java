package fr.louarn.mescomptes.repository;

import fr.louarn.mescomptes.modele.Montant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMontantRepository extends JpaRepository<Montant, Integer> {
}
