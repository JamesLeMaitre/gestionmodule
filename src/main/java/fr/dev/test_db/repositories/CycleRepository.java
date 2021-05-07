package fr.dev.test_db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dev.test_db.entities.Cycle;

public interface CycleRepository extends JpaRepository<Cycle, Long>{

}
