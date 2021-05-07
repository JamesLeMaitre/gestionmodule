package fr.dev.test_db.interfaces;

import java.util.Collection;

import fr.dev.test_db.entities.Teacher;

public interface TeacherInterface {
	Collection<Teacher> teachers();
	
	void addNewTeacher(Teacher teacher, long classroom_id);
	
	boolean deleteTeacher(long id);
	
	Teacher updateTeacher(long id);
}
