package fr.dev.test_db.methodes;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dev.test_db.entities.Teaching_degre;
import fr.dev.test_db.interfaces.TeachingDegreInterface;
import fr.dev.test_db.repositories.TeachingDegreRepository;

@Service
@Transactional
public class TeachingDegreMethode implements TeachingDegreInterface{
	
	@Autowired
	private TeachingDegreRepository teachingDegreRepository;
	@Override
	public Collection<Teaching_degre> teaching_degres() {
		// TODO Auto-generated method stub
		return teachingDegreRepository.findAll();
	}

	@Override
	public void addNewTeachingDegre(Teaching_degre teaching_degre) {
		// TODO Auto-generated method stub
		teachingDegreRepository.save(teaching_degre);
	}

	@Override
	public boolean deleteTeachingDegre(long id) {
		// TODO Auto-generated method stub
		boolean res = false;
		Teaching_degre degre = new Teaching_degre();
		try {
			degre = teachingDegreRepository.findById(id).orElse(null);
			assert degre != null;
			teachingDegreRepository.delete(degre);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			degre = null;
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Teaching_degre updateTeachingDegre(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
