package fr.dev.test_db.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dev.test_db.entities.Classroom;
import fr.dev.test_db.methodes.ClassroomMethode;

@RestController
public class ClassroomRestController {
	
	@Autowired
	private ClassroomMethode classroomMethode;
	
	@PostMapping("/addNewClassroom/{cycle_id}/{membership_id}")
	public boolean addNewClass(@RequestBody Classroom classroom, @PathVariable long membership_id, @PathVariable long cycle_id) {
		boolean res = false;
		try {
			classroomMethode.addNewClassroom(classroom, cycle_id, membership_id);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}
	
	@GetMapping("/deleteClassroom/{id}")
	public boolean deleteClass(@PathVariable long id) {
		return classroomMethode.deleteClassroom(id);
	}
	
	@GetMapping("/updateClassroom/{id}")
	public Classroom updateClassrooms(@PathVariable long id) {
		return classroomMethode.updateClassroom(id);
	}

}
