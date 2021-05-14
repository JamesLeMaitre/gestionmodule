package fr.dev.test_db.methodes;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dev.test_db.entities.Academical;
import fr.dev.test_db.interfaces.AcademicalInterface;
import fr.dev.test_db.repositories.AcademicalRepository;

@Service
@Transactional
public class AcademicalMethode implements AcademicalInterface {
    @Autowired
    private AcademicalRepository academicalRepository;

	@Override
	public Collection<Academical> academicals() {
		// TODO Auto-generated method stub
		return academicalRepository.findAll();
	}

	@Override
	public void addNewAcademical(Academical academical) {
		// TODO Auto-generated method stub
		academicalRepository.save(academical);
		
	}

	@Override
	public boolean deleteAcadelical(long id) {
		 boolean res = false;
	        Academical academical = new Academical();
	        try {
	        	academical = academicalRepository.findById(id).orElse(null);
	            assert academical != null;
	            academicalRepository.delete(academical);
	            res = true;
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }
	        return res;
	}

	@Override
	public Academical updateAcademical(long id) {
		// TODO Auto-generated method stub
		Academical academical = new Academical();
		try {
			academical = academicalRepository.findById(id).orElse(null);
            assert academical != null;
           // System.out.println(academical);
		} catch (Exception e) {
			// TODO: handle exception
			academical = null;
			e.printStackTrace();
		}
		return academical;
	}

   

}
