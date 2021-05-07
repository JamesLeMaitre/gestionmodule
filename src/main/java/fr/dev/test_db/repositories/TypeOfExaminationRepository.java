package fr.dev.test_db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dev.test_db.entities.TypeOfExamination;

public interface TypeOfExaminationRepository extends JpaRepository<TypeOfExamination, Long>{

}
