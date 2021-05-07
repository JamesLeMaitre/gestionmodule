package fr.dev.test_db.interfaces;

import java.util.Collection;

import fr.dev.test_db.entities.Note;

public interface NoteInterface {

	Collection<Note> notes();

	void addNewNote(Note note, long student_id, long examination_id, long subject_id);

	boolean deleteNote(long id);

	Note updateNote(long id);

}
