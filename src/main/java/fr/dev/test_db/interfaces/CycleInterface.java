package fr.dev.test_db.interfaces;

import java.util.Collection;

import fr.dev.test_db.entities.Cycle;

public interface CycleInterface {
	Collection<Cycle> cycles();
	
	void addNewCycle(Cycle cycle);
	
	boolean deleteCycle(long id);
	
	Cycle updateCycle(long id); 

}
