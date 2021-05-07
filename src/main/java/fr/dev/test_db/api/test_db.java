package fr.dev.test_db.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dev.test_db.entities.Classroom;
import fr.dev.test_db.methodes.ClassroomMethode;

@RestController
@RequestMapping("/api")
public class test_db {
	@Autowired
	private ClassroomMethode classroomMethode;
	
	 @GetMapping(path = "/classrooms", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Iterable<Classroom>> findAll() {
	        try {

	            return new ResponseEntity<Iterable<Classroom>>(classroomMethode.classrooms(), HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<Iterable<Classroom>>(HttpStatus.BAD_REQUEST);
	        }
	    }
}
