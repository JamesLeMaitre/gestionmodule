package fr.dev.test_db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dev.test_db.entities.Note;

public interface NoteRepository extends JpaRepository<Note, Long>{

}
