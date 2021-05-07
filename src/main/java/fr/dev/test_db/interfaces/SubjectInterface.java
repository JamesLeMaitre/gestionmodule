package fr.dev.test_db.interfaces;

import java.util.Collection;

import fr.dev.test_db.entities.Subject;

public interface SubjectInterface {
	Collection<Subject> subjects();

	void addNewSubject(Subject subject, long classroom_id, long teacher_id);

	boolean deleteSubject(long id);

	Subject updateSubject(long id);
}
