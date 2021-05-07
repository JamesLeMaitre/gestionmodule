package fr.dev.test_db.methodes;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dev.test_db.entities.Cycle;
import fr.dev.test_db.interfaces.CycleInterface;
import fr.dev.test_db.repositories.CycleRepository;

@Service
@Transactional
public class CycleMethode implements CycleInterface{

	@Autowired
	private CycleRepository cycleRepository;
	@Override
	public Collection<Cycle> cycles() {
		// TODO Auto-generated method stub
		return cycleRepository.findAll();
	}

	@Override
	public void addNewCycle(Cycle cycle) {
		// TODO Auto-generated method stub
		cycleRepository.save(cycle);
	}

	@Override
	public boolean deleteCycle(long id) {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			Cycle cycle = new Cycle();
			cycle = cycleRepository.findById(id).orElse(null);
			assert cycle != null;
			cycleRepository.delete(cycle);
			res =true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Cycle updateCycle(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
