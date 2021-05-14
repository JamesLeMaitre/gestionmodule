package fr.dev.test_db.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dev.test_db.entities.Teacher;
import fr.dev.test_db.methodes.TeacherMethode;

@RestController
public class TeacherRestController {
	@Autowired
	private TeacherMethode teacherMethode;
	
	@PostMapping("/addNewTeacher/{classroom_id}")
	public boolean addTeacher(@RequestBody Teacher teacher, @PathVariable long classroom_id) {
		boolean res = false;
		try {
			teacherMethode.addNewTeacher(teacher, classroom_id);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}
	
	@GetMapping("/deleteTeacher/{id}")
	public boolean deleteTeachers(@PathVariable long id) {
		return teacherMethode.deleteTeacher(id);
	}
	
	@GetMapping("/updateTeacher/{id}")
	public Teacher updateTeacher(@PathVariable long id) {
		return teacherMethode.updateTeacher(id);
	}

}
