package fr.louarn.mescomptes.repository;

import fr.louarn.mescomptes.modele.Devise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeviseRepository extends JpaRepository<Devise, String> {
}
