package fr.dev.test_db.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idStudent;

	@Column(nullable = false, length = 12, name = "firstname")
	private String firstnameStudent;

	@Column(nullable = false, length = 12, name = "lastname")
	private String lastnameStudent;

	@Column(nullable = false, columnDefinition = "CHAR(1)", name = "sex")
	private String sexStudent;

	@Column(name = "birthday", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private String birthdayStudent;

	@Column(nullable = false, length = 20, name = "placeofbirth")
	private String placeofbirthStudent;

	@Column(nullable = false, columnDefinition = "CHAR(1)", name = "statut")
	private String statutStudent;

	@Column(nullable = false, length = 15, name = "adresse")
	private String adressStudent;

	@Column(name = "is_active", columnDefinition = "BOOLEAN DEFAULT FALSE")
	private Boolean activeStudent;

	@Column(name = "serialnumber", nullable = false, length = 10, unique = true)
	private String serialnumberStudent;

	@Column(name = "persontocontact", nullable = false, columnDefinition = "INT(8)")
	private String persontocontactStudent;

	@Column(name = "physicalstate", nullable = false, length = 10)
	private String physicalstateStudent;

	@Column(name = "maritalstatus", nullable = false, length = 25)
	private String maritalstatusStudent;

	@Column(name = "schooloforigin", nullable = false, length = 25)
	private String schooloforiginStudent;

	@ManyToOne
	@JoinColumn(name = "classroom_id", nullable = false)
	private Classroom classroom;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_id", nullable = false)
	private Teacher teacher;

	@ManyToOne
	@JoinColumn(name = "registration_id", nullable = false)
	private Registration registration;

	@ManyToOne
	@JoinColumn(name = "parents_id", nullable = false)
	private Parents parents;
	/*
	 * @ManyToMany
	 *
	 * @JoinTable(name = "note_student", joinColumns = @JoinColumn(name =
	 * "student_id"), inverseJoinColumns = @JoinColumn(name = "subject_id")) private
	 * Collection<Subject> subjects;
	 */
	@OneToMany(mappedBy = "student")
	private Set<Note> notes;

	public long getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(long idStudent) {
		this.idStudent = idStudent;
	}

	public String getFirstnameStudent() {
		return firstnameStudent;
	}

	public void setFirstnameStudent(String firstnameStudent) {
		this.firstnameStudent = firstnameStudent;
	}

	public String getLastnameStudent() {
		return lastnameStudent;
	}

	public void setLastnameStudent(String lastnameStudent) {
		this.lastnameStudent = lastnameStudent;
	}

	public String getSexStudent() {
		return sexStudent;
	}

	public void setSexStudent(String sexStudent) {
		this.sexStudent = sexStudent;
	}

	public String getBirthdayStudent() {
		return birthdayStudent;
	}

	public void setBirthdayStudent(String birthdayStudent) {
		this.birthdayStudent = birthdayStudent;
	}

	public String getPlaceofbirthStudent() {
		return placeofbirthStudent;
	}

	public void setPlaceofbirthStudent(String placeofbirthStudent) {
		this.placeofbirthStudent = placeofbirthStudent;
	}

	public String getStatutStudent() {
		return statutStudent;
	}

	public void setStatutStudent(String statutStudent) {
		this.statutStudent = statutStudent;
	}

	public String getAdressStudent() {
		return adressStudent;
	}

	public void setAdressStudent(String adressStudent) {
		this.adressStudent = adressStudent;
	}

	public Boolean getActiveStudent() {
		return activeStudent;
	}

	public void setActiveStudent(Boolean activeStudent) {
		this.activeStudent = activeStudent;
	}

	public String getSerialnumberStudent() {
		return serialnumberStudent;
	}

	public void setSerialnumberStudent(String serialnumberStudent) {
		this.serialnumberStudent = serialnumberStudent;
	}

	public String getPersontocontactStudent() {
		return persontocontactStudent;
	}

	public void setPersontocontactStudent(String persontocontactStudent) {
		this.persontocontactStudent = persontocontactStudent;
	}

	public String getPhysicalstateStudent() {
		return physicalstateStudent;
	}

	public void setPhysicalstateStudent(String physicalstateStudent) {
		this.physicalstateStudent = physicalstateStudent;
	}

	public String getMaritalstatusStudent() {
		return maritalstatusStudent;
	}

	public void setMaritalstatusStudent(String maritalstatusStudent) {
		this.maritalstatusStudent = maritalstatusStudent;
	}

	public String getSchooloforiginStudent() {
		return schooloforiginStudent;
	}

	public void setSchooloforiginStudent(String schooloforiginStudent) {
		this.schooloforiginStudent = schooloforiginStudent;
	}

	@JsonIgnore
	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public Parents getParents() {
		return parents;
	}

	public void setParents(Parents parents) {
		this.parents = parents;
	}

	public Set<Note> getNotes() {
		return notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

	public Student(String firstnameStudent, String lastnameStudent, String sexStudent, String birthdayStudent,
			String placeofbirthStudent, String statutStudent, String adressStudent, Boolean activeStudent,
			String serialnumberStudent, String persontocontactStudent, String physicalstateStudent,
			String maritalstatusStudent, String schooloforiginStudent, Classroom classroom, Teacher teacher,
			Registration registration, Parents parents, Set<Note> notes) {
		super();
		this.firstnameStudent = firstnameStudent;
		this.lastnameStudent = lastnameStudent;
		this.sexStudent = sexStudent;
		this.birthdayStudent = birthdayStudent;
		this.placeofbirthStudent = placeofbirthStudent;
		this.statutStudent = statutStudent;
		this.adressStudent = adressStudent;
		this.activeStudent = activeStudent;
		this.serialnumberStudent = serialnumberStudent;
		this.persontocontactStudent = persontocontactStudent;
		this.physicalstateStudent = physicalstateStudent;
		this.maritalstatusStudent = maritalstatusStudent;
		this.schooloforiginStudent = schooloforiginStudent;
		this.classroom = classroom;
		this.teacher = teacher;
		this.registration = registration;
		this.parents = parents;
		this.notes = notes;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
