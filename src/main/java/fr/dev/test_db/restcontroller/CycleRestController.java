package fr.dev.test_db.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dev.test_db.entities.Cycle;
import fr.dev.test_db.methodes.CycleMethode;

@RestController
public class CycleRestController {
	
	@Autowired
	private CycleMethode cycleMethode;
	
	@PostMapping("/addNewCycle")
	public boolean addCycle(@RequestBody Cycle cycle) {
		boolean res = false;
		try {
			cycleMethode.addNewCycle(cycle);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}
	
	@GetMapping("/deleteCycle/{id}")
	public boolean deleteCycles(@PathVariable long id) {
		return cycleMethode.deleteCycle(id);
	}
	
	@GetMapping("/updateCycle/{id}")
	public Cycle updateCycles(@PathVariable long id) {
		return cycleMethode.updateCycle(id);
	}

}
