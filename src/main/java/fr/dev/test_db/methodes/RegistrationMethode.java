package fr.dev.test_db.methodes;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dev.test_db.entities.Academical;
import fr.dev.test_db.entities.Registration;
import fr.dev.test_db.interfaces.RegistrationInterface;
import fr.dev.test_db.repositories.AcademicalRepository;
import fr.dev.test_db.repositories.RegistrationRepository;

@Service
@Transactional
public class RegistrationMethode implements RegistrationInterface{

	@Autowired
	private RegistrationRepository regisRepository;
	
	@Autowired
	private AcademicalRepository academicalRepository;
	
	@Override
	public Collection<Registration> registrations() {
		// TODO Auto-generated method stub
		return regisRepository.findAll();
	}

	@Override
	public void addNewRegistration(Registration registration, long academical_id) {
		// TODO Auto-generated method stub
		
		Academical a = academicalRepository.findById(academical_id).orElse(null);
		registration.setAcademical(a);
		
		regisRepository.save(registration);
		
	}

	@Override
	public boolean deleteRegistration(long id) {
		// TODO Auto-generated method stub
		boolean res = false;
		Registration registration = new Registration();
		try {
		registration = regisRepository.findById(id).orElse(null);
		assert registration != null;
		regisRepository.delete(registration);
		res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Registration updateRegistration(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
