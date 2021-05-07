package fr.dev.test_db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dev.test_db.entities.School;

public interface SchoolRepository extends JpaRepository<School, Long>{

}
