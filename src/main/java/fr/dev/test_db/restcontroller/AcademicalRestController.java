package fr.dev.test_db.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dev.test_db.entities.Academical;
import fr.dev.test_db.methodes.AcademicalMethode;

@RestController
public class AcademicalRestController {
	
	@Autowired
	private AcademicalMethode academicalMethode;
	
	@PostMapping("/addNewAcademical")
	public boolean addAcademical(@RequestBody Academical academical) {
		boolean res = false;
		try {
			academicalMethode.addNewAcademical(academical);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

	@GetMapping("/deleteAcademical/{id}")
	public boolean deleteAcadelicYear(@PathVariable long id) {
		return academicalMethode.deleteAcadelical(id);
	}
	
	@GetMapping("/updateAcademicalYear/{id}")
	public Academical updateAcademical(@PathVariable long id) {
		return academicalMethode.updateAcademical(id);
	}

}
