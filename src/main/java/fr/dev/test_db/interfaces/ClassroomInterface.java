package fr.dev.test_db.interfaces;

import java.util.Collection;

import fr.dev.test_db.entities.Classroom;

public interface ClassroomInterface {

	Collection<Classroom> classrooms();
	
	void addNewClassroom(Classroom classroom, long cycle_id, long membership_id);
	
	boolean deleteClassroom(long id);
	
	Classroom updateClassroom(long id);
}
