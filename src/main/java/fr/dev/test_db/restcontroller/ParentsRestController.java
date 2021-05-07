package fr.dev.test_db.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dev.test_db.entities.Parents;
import fr.dev.test_db.methodes.ParentsMethode;

@RestController
public class ParentsRestController {
	
	@Autowired
	private ParentsMethode parentsMethode;
	
	@PostMapping("/addNewParents")
	public boolean addParents(@RequestBody Parents parents) {
		boolean res = false;
		try {
			parentsMethode.addNaewParents(parents);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}
	
	@GetMapping("/deleteParents/{id}")
	public boolean deleteParent(@PathVariable long id) {
		return parentsMethode.deleteParents(id);
	}

}
