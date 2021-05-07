package fr.dev.test_db.interfaces;

import java.util.Collection;

import fr.dev.test_db.entities.Student;

public interface StudentInterface {

	Collection<Student> students();

	void addNewStudent(Student student, long registration_id, long parents_id, long classroom_id, long teacher_id);

	boolean deleteStudent(long id);

	Student updateStudent(long id);
}
