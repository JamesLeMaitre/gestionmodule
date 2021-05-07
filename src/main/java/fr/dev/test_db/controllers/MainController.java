package fr.dev.test_db.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.dev.test_db.methodes.AcademicalMethode;
import fr.dev.test_db.methodes.ClassroomMethode;
import fr.dev.test_db.methodes.CycleMethode;
import fr.dev.test_db.methodes.NoteMethode;
import fr.dev.test_db.methodes.ParentsMethode;
import fr.dev.test_db.methodes.RegistrationMethode;
import fr.dev.test_db.methodes.SchoolMembershipMethode;
import fr.dev.test_db.methodes.SchoolMethode;
import fr.dev.test_db.methodes.StudentMethode;
import fr.dev.test_db.methodes.SubjectMethode;
import fr.dev.test_db.methodes.TeacherMethode;
import fr.dev.test_db.methodes.TeachingDegreMethode;
import fr.dev.test_db.methodes.TypeOfExaminationMethode;

@Controller
public class MainController {
	@Autowired
	private AcademicalMethode academicalMethode;

	@Autowired
	private CycleMethode cycleMethode;

	@Autowired
	private RegistrationMethode registrationMethode;

	@Autowired
	private SchoolMethode schoolMethode;

	@Autowired
	private TeachingDegreMethode teachingDegreMethode;

	@Autowired
	private SchoolMembershipMethode membershipMethode;

	@Autowired
	private ClassroomMethode classroomMethode;

	@Autowired
	private TypeOfExaminationMethode examinationMethode;

	@Autowired
	private ParentsMethode parentsMethode;
	
	@Autowired
	private TeacherMethode teacherMethode;
	
	@Autowired
	private SubjectMethode subjectMethode;
	
	@Autowired
	private StudentMethode studentMethode;
	
	@Autowired
	private NoteMethode noteMethode;

	private static final Logger log = LoggerFactory.getLogger(MainController.class);

	@GetMapping("/")
	public String page(Model m) {
		log.debug("DEBUG Info");
		m.addAttribute("classrooms", classroomMethode.classrooms());
		m.addAttribute("teachers", teacherMethode.teachers());
		m.addAttribute("academicals", academicalMethode.academicals());
		m.addAttribute("cycles", cycleMethode.cycles());
		m.addAttribute("registrations", registrationMethode.registrations());
		m.addAttribute("degres", teachingDegreMethode.teaching_degres());
		return "index";
	}

	@GetMapping("/page")
	public String view(Model m) {
		m.addAttribute("academicals", academicalMethode.academicals());
		m.addAttribute("schoolss", schoolMethode.schools());
		m.addAttribute("degres", teachingDegreMethode.teaching_degres());
		m.addAttribute("memberships", membershipMethode.school_memberships());
		m.addAttribute("classrooms", classroomMethode.classrooms());
		m.addAttribute("cycles", cycleMethode.cycles());
		m.addAttribute("examinations", examinationMethode.examinations());
		return "page";
	}

	@GetMapping("/studentinfo")
	public String vue(Model m) {
		m.addAttribute("parents", parentsMethode.parents());
		m.addAttribute("classrooms", classroomMethode.classrooms());
		m.addAttribute("teachers", teacherMethode.teachers());
		m.addAttribute("subjects", subjectMethode.subjects());
		return "vue";
	}
	
	@GetMapping("/studentPage")
	public String student(Model m) {
		m.addAttribute("subjects", subjectMethode.subjects());
		m.addAttribute("examinations", examinationMethode.examinations());
		m.addAttribute("academicals", academicalMethode.academicals());
		m.addAttribute("classrooms", classroomMethode.classrooms());
		m.addAttribute("teachers", teacherMethode.teachers());
		m.addAttribute("parents", parentsMethode.parents());
		m.addAttribute("registrations", registrationMethode.registrations());
		m.addAttribute("students", studentMethode.students());
		m.addAttribute("notes", noteMethode.notes());
		return "student";
	}
}
