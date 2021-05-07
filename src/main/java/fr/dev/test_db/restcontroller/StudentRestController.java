package fr.dev.test_db.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dev.test_db.entities.Student;
import fr.dev.test_db.methodes.StudentMethode;

@RestController
public class StudentRestController {

	@Autowired
	private StudentMethode studentMethode;

	@PostMapping("/addNewStudent/{registration_id}/{parents_id}/{classroom_id}/{teacher_id}")
	public boolean addStudent(@RequestBody Student student, @PathVariable long registration_id,
			@PathVariable long parents_id, @PathVariable long classroom_id, @PathVariable long teacher_id) {
		boolean res = false;
		try {
			studentMethode.addNewStudent(student, registration_id, parents_id, classroom_id, teacher_id);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

	@GetMapping("/deleteStudent/{id}")
	public boolean deleteStudents(@PathVariable long id) {
		return studentMethode.deleteStudent(id);
	}
}
