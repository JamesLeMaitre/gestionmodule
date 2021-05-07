package fr.dev.test_db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dev.test_db.entities.School_membership;

public interface SchoolMembershipRepository extends JpaRepository<School_membership, Long>{

}
