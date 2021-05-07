package fr.dev.test_db.interfaces;

import java.util.Collection;

import fr.dev.test_db.entities.School_membership;

public interface SchoolMembershipInterface {

	Collection<School_membership> school_memberships();
	
	void addNewSchoolMembership(School_membership school_membership, long teachDegre);
	
	boolean deleteSchoolMembership(long id);
	
	School_membership updateSchoolMembership(long id);
}
