package fr.dev.test_db.methodes;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dev.test_db.entities.Classroom;
import fr.dev.test_db.entities.Parents;
import fr.dev.test_db.entities.Registration;
import fr.dev.test_db.entities.Student;
import fr.dev.test_db.entities.Teacher;
import fr.dev.test_db.interfaces.StudentInterface;
import fr.dev.test_db.repositories.ClassroomRepository;
import fr.dev.test_db.repositories.ParentsRepository;
import fr.dev.test_db.repositories.RegistrationRepository;
import fr.dev.test_db.repositories.StudentRepository;
import fr.dev.test_db.repositories.TeacherRepository;

@Service
@Transactional
public class StudentMethode implements StudentInterface{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Autowired
	private ParentsRepository parentsRepository;
	
	@Autowired
	private ClassroomRepository classroomRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Override
	public Collection<Student> students() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public void addNewStudent(Student student, long registration_id, long parents_id, long classroom_id,
			long teacher_id) {
		// TODO Auto-generated method stub
		Registration registration = registrationRepository.findById(registration_id).orElse(null);
		student.setRegistration(registration);
		
		Parents parents = parentsRepository.findById(parents_id).orElse(null);
		student.setParents(parents);
		
		Classroom classroom = classroomRepository.findById(classroom_id).orElse(null);
		student.setClassroom(classroom);
		
		Teacher teacher = teacherRepository.findById(teacher_id).orElse(null);
		student.setTeacher(teacher);
		
		studentRepository.save(student);
	}

	@Override
	public boolean deleteStudent(long id) {
		// TODO Auto-generated method stub
		boolean res = false;
		Student student = new Student();
		try {
			student = studentRepository.findById(id).orElse(null);
			assert student != null;
			studentRepository.delete(student);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Student updateStudent(long id) {
		// TODO Auto-generated method stub
		Student student = new Student();
		try {
			student = studentRepository.findById(id).orElse(null);
			assert student != null;
		} catch (Exception e) {
			e.printStackTrace();
			student = null;
			// TODO: handle exception
		}
		return student;
	}

}
