package fr.dev.test_db.interfaces;

import java.util.Collection;

import fr.dev.test_db.entities.Teaching_degre;

public interface TeachingDegreInterface {
	Collection<Teaching_degre> teaching_degres();
	
	void addNewTeachingDegre(Teaching_degre teaching_degre);
	
	boolean deleteTeachingDegre(long id);
	
	Teaching_degre updateTeachingDegre(long id);
}
