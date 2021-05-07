package fr.dev.test_db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dev.test_db.entities.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long>{

}
