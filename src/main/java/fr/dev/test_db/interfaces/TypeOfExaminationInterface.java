package fr.dev.test_db.interfaces;

import java.util.Collection;

import fr.dev.test_db.entities.TypeOfExamination;

public interface TypeOfExaminationInterface {

	Collection<TypeOfExamination> examinations();
	
	void addNewTypeOfExamination(TypeOfExamination examination);
	
	boolean deleteTypeOfExamination(long id);
	
	TypeOfExamination updateTypeOfExamination(long id);
}
