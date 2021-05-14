package fr.dev.test_db.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dev.test_db.entities.Note;
import fr.dev.test_db.methodes.NoteMethode;

@RestController
public class NoteRestController {
	@Autowired
	private NoteMethode noteMethode;

	@PostMapping("/addNewNote/{student_id}/{examination_id}/{subject_id}")
	public boolean addNote(@RequestBody Note note, @PathVariable long student_id, @PathVariable long examination_id,
			@PathVariable long subject_id) {
		boolean res = false;
		try {
			noteMethode.addNewNote(note, student_id, examination_id, subject_id);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

	@GetMapping("/deleteNote/{id}")
	public boolean deleteNotes(@PathVariable long id) {
		return noteMethode.deleteNote(id);
	}

	@GetMapping("/updateNote/{id}")
	public Note updateNote(@PathVariable long id) {
		return noteMethode.updateNote(id);
	}

}
