package fr.dev.test_db.methodes;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dev.test_db.entities.Classroom;
import fr.dev.test_db.entities.Teacher;
import fr.dev.test_db.interfaces.TeacherInterface;
import fr.dev.test_db.repositories.ClassroomRepository;
import fr.dev.test_db.repositories.TeacherRepository;

@Service
@Transactional
public class TeacherMethode implements TeacherInterface{

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private ClassroomRepository classroomRepository;
	
	@Override
	public Collection<Teacher> teachers() {
		// TODO Auto-generated method stub
		return teacherRepository.findAll();
	}

	@Override
	public void addNewTeacher(Teacher teacher, long classroom_id) {
		// TODO Auto-generated method stub
		Classroom classroom = classroomRepository.findById(classroom_id).orElse(null);
		teacher.setClassroom(classroom);
		
		teacherRepository.save(teacher);
		
	}

	@Override
	public boolean deleteTeacher(long id) {
		// TODO Auto-generated method stub
		boolean res = false;
		Teacher teacher = new Teacher();
		try {
			teacher = teacherRepository.findById(id).orElse(null);
			assert teacher != null;
			teacherRepository.delete(teacher);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Teacher updateTeacher(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
