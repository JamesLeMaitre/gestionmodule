package fr.dev.test_db.interfaces;

import java.util.Collection;

import fr.dev.test_db.entities.Parents;

public interface ParentsInterface {
	
	Collection<Parents> parents();
	
	void addNaewParents(Parents parents);
	
	boolean deleteParents(long id);
	
	Parents updateParents(long id);

}
