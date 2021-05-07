package fr.dev.test_db.interfaces;

import java.util.Collection;

import fr.dev.test_db.entities.Registration;

public interface RegistrationInterface {

	Collection<Registration> registrations();
	
	void addNewRegistration(Registration registration, long academical_id);
	
	boolean deleteRegistration(long id);
	
	Registration updateRegistration(long id);
}
