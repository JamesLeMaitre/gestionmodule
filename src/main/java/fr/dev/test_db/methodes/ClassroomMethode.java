package fr.dev.test_db.methodes;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dev.test_db.entities.Classroom;
import fr.dev.test_db.entities.Cycle;
import fr.dev.test_db.entities.School_membership;
import fr.dev.test_db.interfaces.ClassroomInterface;
import fr.dev.test_db.repositories.ClassroomRepository;
import fr.dev.test_db.repositories.CycleRepository;
import fr.dev.test_db.repositories.SchoolMembershipRepository;

@Service
@Transactional
public class ClassroomMethode implements ClassroomInterface{
	
	@Autowired
	private ClassroomRepository classroomRepository;
	
	@Autowired
	private CycleRepository cycleRepository;
	
	@Autowired
	private SchoolMembershipRepository membershipRepository;
	
	@Override
	public Collection<Classroom> classrooms() {
		// TODO Auto-generated method stub
		return classroomRepository.findAll();
	}

	@Override
	public void addNewClassroom(Classroom classroom, long cycle_id, long membership_id) {
		// TODO Auto-generated method stub
		
		Cycle cycle = new Cycle();
		cycle = cycleRepository.findById(cycle_id).orElse(null);
		classroom.setCycle(cycle);
		
		School_membership membership = new School_membership();
		membership = membershipRepository.findById(membership_id).orElse(null);
		classroom.setMembership(membership);
		
		classroomRepository.save(classroom);
		
	}

	@Override
	public boolean deleteClassroom(long id) {
		// TODO Auto-generated method stub
		boolean res = false;
		Classroom classroom = new Classroom();
		try {
			classroom = classroomRepository.findById(id).orElse(null);
			assert classroom !=null;
			classroomRepository.delete(classroom);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Classroom updateClassroom(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
