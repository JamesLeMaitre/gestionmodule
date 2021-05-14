package fr.dev.test_db.methodes;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dev.test_db.entities.Parents;
import fr.dev.test_db.interfaces.ParentsInterface;
import fr.dev.test_db.repositories.ParentsRepository;

@Service
@Transactional
public class ParentsMethode implements ParentsInterface{

	@Autowired
	private ParentsRepository parentsRepository;
	
	@Override
	public Collection<Parents> parents() {
		// TODO Auto-generated method stub
		return parentsRepository.findAll();
	}

	@Override
	public void addNaewParents(Parents parents) {
		// TODO Auto-generated method stub
		parentsRepository.save(parents);
	}

	@Override
	public boolean deleteParents(long id) {
		// TODO Auto-generated method stub
		boolean res = false;
		Parents parents = new Parents();
		try {
			parents = parentsRepository.findById(id).orElse(null);
			assert parents != null;
			parentsRepository.delete(parents);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Parents updateParents(long id) {
		// TODO Auto-generated method stub
		Parents parents = new Parents();
		try {
			parents = parentsRepository.findById(id).orElse(null);
			assert parents != null;
		} catch (Exception e) {
			// TODO: handle exception
			parents = null;
			e.printStackTrace();
		}
		return parents;
	}

}
