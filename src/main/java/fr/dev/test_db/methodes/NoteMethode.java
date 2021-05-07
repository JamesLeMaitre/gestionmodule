package fr.dev.test_db.methodes;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dev.test_db.entities.Note;
import fr.dev.test_db.entities.Student;
import fr.dev.test_db.entities.Subject;
import fr.dev.test_db.entities.TypeOfExamination;
import fr.dev.test_db.interfaces.NoteInterface;
import fr.dev.test_db.repositories.NoteRepository;
import fr.dev.test_db.repositories.StudentRepository;
import fr.dev.test_db.repositories.SubjectRepository;
import fr.dev.test_db.repositories.TypeOfExaminationRepository;

@Service
@Transactional
public class NoteMethode implements NoteInterface{

	@Autowired
	private NoteRepository noteRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private TypeOfExaminationRepository examinationRepository;
	
	@Override
	public Collection<Note> notes() {
		// TODO Auto-generated method stub
		return noteRepository.findAll();
	}

	@Override
	public void addNewNote(Note note, long student_id, long examination_id, long subject_id) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(student_id).orElse(null);
		note.setStudent(student);
		
		TypeOfExamination examination = examinationRepository.findById(examination_id).orElse(null);
		note.setExamination(examination);
		
		Subject subject = subjectRepository.findById(subject_id).orElse(null);
		note.setSubject(subject);
		
		noteRepository.save(note);
		
	}

	@Override
	public boolean deleteNote(long id) {
		// TODO Auto-generated method stub
		boolean res = false;
		Note note = new Note();
		try {
			note = noteRepository.findById(id).orElse(null);
			assert note != null;
			noteRepository.delete(note);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Note updateNote(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
