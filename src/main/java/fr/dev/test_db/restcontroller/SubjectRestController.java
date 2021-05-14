package fr.dev.test_db.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dev.test_db.entities.Subject;
import fr.dev.test_db.methodes.SubjectMethode;

@RestController
public class SubjectRestController {

	@Autowired
	private SubjectMethode subjectMethode;
	
	@PostMapping("/addNewSubject/{classroom_id}/{teacher_id}")
	public boolean addSubject(@RequestBody Subject subject, @PathVariable long classroom_id, @PathVariable long teacher_id) {
		boolean res = false;
		try {
			subjectMethode.addNewSubject(subject, classroom_id, teacher_id);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}
	
	@GetMapping("/deleteSubject/{id}")
	public boolean deleteSubjects(@PathVariable long id) {
		return subjectMethode.deleteSubject(id);
	}
	
	@GetMapping("/updateSubject/{id}")
	public Subject updatingSubject(@PathVariable long id) {
		return subjectMethode.updateSubject(id);
	}
}
