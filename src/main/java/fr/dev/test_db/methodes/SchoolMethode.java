package fr.dev.test_db.methodes;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dev.test_db.entities.Academical;
import fr.dev.test_db.entities.School;
import fr.dev.test_db.interfaces.SchoolInterface;
import fr.dev.test_db.repositories.AcademicalRepository;
import fr.dev.test_db.repositories.SchoolRepository;

@Service
@Transactional
public class SchoolMethode implements SchoolInterface{
	 @Autowired
	 private SchoolRepository schoolRepository;
	 
	 @Autowired
	 private AcademicalRepository academicalRepository;
	 
	@Override
	public Collection<School> schools() {
		// TODO Auto-generated method stub
		return schoolRepository.findAll();
	}

	@Override
	public void addNewSchool(School school, long academical_id) {
		// TODO Auto-generated method stub
		
		Academical academical = academicalRepository.findById(academical_id).orElse(null);
		school.setAcademical(academical);
		
		schoolRepository.save(school);
	}

	@Override
	public boolean deleteSchool(long id) {
		// TODO Auto-generated method stub
		boolean res = false;
		School school = new School();
		try {
			 school = schoolRepository.findById(id).orElse(null);
			 assert school != null;
			 schoolRepository.delete(school);
			 res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public School updateSchoolInfo(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
