package fr.dev.test_db.methodes;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dev.test_db.entities.Classroom;
import fr.dev.test_db.entities.Subject;
import fr.dev.test_db.entities.Teacher;
import fr.dev.test_db.interfaces.SubjectInterface;
import fr.dev.test_db.repositories.ClassroomRepository;
import fr.dev.test_db.repositories.SubjectRepository;
import fr.dev.test_db.repositories.TeacherRepository;

@Service
@Transactional
public class SubjectMethode implements SubjectInterface{
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private ClassroomRepository classroomRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Override
	public Collection<Subject> subjects() {
		// TODO Auto-generated method stub
		return subjectRepository.findAll();
	}

	@Override
	public void addNewSubject(Subject subject, long classroom_id, long teacher_id) {
		// TODO Auto-generated method stub
		Classroom classroom = classroomRepository.findById(classroom_id).orElse(null);
		subject.setClassroom(classroom);
		
		Teacher teacher = teacherRepository.findById(teacher_id).orElse(null);
		subject.setTeacher(teacher);
		
		subjectRepository.save(subject);
		
	}

	@Override
	public boolean deleteSubject(long id) {
		// TODO Auto-generated method stub
		boolean res = false;
		Subject subject = new Subject();
		try {
			subject = subjectRepository.findById(id).orElse(null);
			assert subject != null;
			subjectRepository.delete(subject);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Subject updateSubject(long id) {
		// TODO Auto-generated method stub
		Subject subject = new Subject();
		try {
			subject = subjectRepository.findById(id).orElse(null);
			assert subject != null;
		} catch (Exception e) {
			// TODO: handle exception
			subject = null;
			e.printStackTrace();
		}
		System.out.println(subject);
		return subject;
	}

}
