package fr.dev.test_db.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dev.test_db.entities.Teaching_degre;
import fr.dev.test_db.methodes.TeachingDegreMethode;

@RestController
public class TeachingDegreRestController {
	
	@Autowired
	private TeachingDegreMethode teachingDegreMethode;
	
	@PostMapping("/addNewTeachingDegre")
	public boolean addTeachingDegre( @RequestBody Teaching_degre teaching_degre) {
		boolean res = false;
		try {
			teachingDegreMethode.addNewTeachingDegre(teaching_degre);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}
	
	@GetMapping("/deleteTeachingDegre/{id}")
	public boolean deleteTeachingDeg(@PathVariable long id) {
		return teachingDegreMethode.deleteTeachingDegre(id);
	}

}
