package fr.dev.test_db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dev.test_db.entities.Academical;

public interface AcademicalRepository extends JpaRepository<Academical, Long>{

}
