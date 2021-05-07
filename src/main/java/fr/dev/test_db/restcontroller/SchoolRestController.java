package fr.dev.test_db.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dev.test_db.entities.School;
import fr.dev.test_db.methodes.SchoolMethode;

@RestController
public class SchoolRestController {
	
	@Autowired
	private SchoolMethode schoolMethode;
	
	@PostMapping("/addNewSchool/{id}")
	public boolean addSchool(@RequestBody School school, @PathVariable long id) {
		boolean res = false;
		try {
			schoolMethode.addNewSchool(school, id);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}
	
	@GetMapping("/deleteSchool/{id}")
	public boolean deleteSchools(@PathVariable long id) {
		return schoolMethode.deleteSchool(id);
	}

}
