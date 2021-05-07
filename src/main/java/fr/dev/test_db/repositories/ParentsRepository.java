package fr.dev.test_db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dev.test_db.entities.Parents;

public interface ParentsRepository extends JpaRepository<Parents, Long>{

}
