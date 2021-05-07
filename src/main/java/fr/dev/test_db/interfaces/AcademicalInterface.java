package fr.dev.test_db.interfaces;

import java.util.Collection;

import fr.dev.test_db.entities.Academical;

public interface AcademicalInterface {
	
	Collection<Academical> academicals();
	
	void addNewAcademical(Academical academical);
	
	boolean deleteAcadelical(long id);
	
	Academical updateAcademical(long id);

}
