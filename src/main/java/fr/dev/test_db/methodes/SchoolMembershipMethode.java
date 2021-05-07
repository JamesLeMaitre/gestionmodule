package fr.dev.test_db.methodes;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dev.test_db.entities.School_membership;
import fr.dev.test_db.entities.Teaching_degre;
import fr.dev.test_db.interfaces.SchoolMembershipInterface;
import fr.dev.test_db.repositories.SchoolMembershipRepository;
import fr.dev.test_db.repositories.TeachingDegreRepository;

@Service
@Transactional
public class SchoolMembershipMethode implements SchoolMembershipInterface {
	@Autowired
	private SchoolMembershipRepository schoolMembershipRepository;

	@Autowired
	private TeachingDegreRepository teachingRepository;

	@Override
	public Collection<School_membership> school_memberships() {
		// TODO Auto-generated method stub
		return schoolMembershipRepository.findAll();
	}

	@Override
	public void addNewSchoolMembership(School_membership school_membership, long teachDegre) {
		// TODO Auto-generated method stub
		
		Teaching_degre degre = teachingRepository.findById(teachDegre).orElse(null);
		school_membership.setDegre(degre);

		schoolMembershipRepository.save(school_membership);
	}

	@Override
	public boolean deleteSchoolMembership(long id) {
		// TODO Auto-generated method stub
		boolean res = false;
		School_membership membership = new School_membership();
		try {
			membership = schoolMembershipRepository.findById(id).orElse(null);
			assert membership != null;
			schoolMembershipRepository.delete(membership);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public School_membership updateSchoolMembership(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
