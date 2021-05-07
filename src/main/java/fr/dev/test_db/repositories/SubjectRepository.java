package fr.dev.test_db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dev.test_db.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{

}
