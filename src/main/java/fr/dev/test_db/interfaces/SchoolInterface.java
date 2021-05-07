package fr.dev.test_db.interfaces;

import java.util.Collection;

import fr.dev.test_db.entities.School;

public interface SchoolInterface {
	Collection<School> schools();
	
	void addNewSchool(School school, long academical_id);
	
	boolean deleteSchool(long id);
	
	School updateSchoolInfo(long id);
}
