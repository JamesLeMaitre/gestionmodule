package fr.dev.test_db.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dev.test_db.entities.TypeOfExamination;
import fr.dev.test_db.methodes.TypeOfExaminationMethode;

@RestController
public class TypeOfExaminationRestController {
	
	@Autowired
	private TypeOfExaminationMethode examinationMethode;
	
	@PostMapping("/addNewTypeOfExamination")
	public boolean addTypeOfExamination(@RequestBody TypeOfExamination examination) {
		boolean res = false;
		try {
			examinationMethode.addNewTypeOfExamination(examination);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}
	
	@GetMapping("/deleteTypeOfexamination/{id}")
	public boolean deleteTypeOfExamination(@PathVariable long id) {
		return examinationMethode.deleteTypeOfExamination(id);
	}

}
