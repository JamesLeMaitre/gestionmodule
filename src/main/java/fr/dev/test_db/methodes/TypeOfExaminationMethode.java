package fr.dev.test_db.methodes;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dev.test_db.entities.TypeOfExamination;
import fr.dev.test_db.interfaces.TypeOfExaminationInterface;
import fr.dev.test_db.repositories.TypeOfExaminationRepository;

@Service
@Transactional
public class TypeOfExaminationMethode implements TypeOfExaminationInterface{
	
	@Autowired
	private TypeOfExaminationRepository examinationRepository;
	
	@Override
	public Collection<TypeOfExamination> examinations() {
		// TODO Auto-generated method stub
		return examinationRepository.findAll();
	}

	@Override
	public void addNewTypeOfExamination(TypeOfExamination examination) {
		// TODO Auto-generated method stub
		examinationRepository.save(examination);
		
	}

	@Override
	public boolean deleteTypeOfExamination(long id) {
		// TODO Auto-generated method stub
		boolean res = false;
		TypeOfExamination examination = new TypeOfExamination();
		try {
			examination = examinationRepository.findById(id).orElse(null);
			assert examination != null;
			examinationRepository.delete(examination);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public TypeOfExamination updateTypeOfExamination(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
