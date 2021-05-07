package fr.dev.test_db.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTeacher;
    /* Nom du maitre */
    @Column(nullable = false, length = 15, name = "firstname")
    private String firstnameTeacher;

    /* Prenom du maitre */
    @Column(nullable = false, length = 25, name = "lastname")
    private String lastnameTeacher;

    @Column(nullable = false, length = 25, name = "address")
    private String addressTeacher;

    @Column(nullable = false, length = 1, columnDefinition = "CHAR(1)", name = "sex")
    private String sexTeacher;

    @Column(nullable = false, length = 35, name = "email")
    private String emailTeacher;

    @Column(nullable = false, name = "phone", columnDefinition = "INT(10)")
    private String phoneTeacher;

    @Column(nullable = false, unique = true, length = 10, name = "pobox")
    private String postboxTeacher;

    /* Numero matricule */
    @Column(nullable = false, unique = true, length = 12, name = "serialnumber")
    private String serialnumberTeacher;

    /* Numero de la pièce d'identité */
    @Column(nullable = false, unique = true, length = 19, name = "idnumber")
    private String idnumberTeacher;

    /* Type de la pièce d'identité */
    @Column(nullable = false, length = 19, name = "typeid")
    private String typeidTeacher;

    @OneToOne
    @JoinColumn(name = "classroom_id", nullable = false)
    private Classroom classroom;

    @OneToMany(mappedBy = "teacher")
    private Collection<Subject> subjects;

    @OneToMany(mappedBy = "teacher")
    private Collection<Student> students;

	public long getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(long idTeacher) {
		this.idTeacher = idTeacher;
	}

	public String getFirstnameTeacher() {
		return firstnameTeacher;
	}

	public void setFirstnameTeacher(String firstnameTeacher) {
		this.firstnameTeacher = firstnameTeacher;
	}

	public String getLastnameTeacher() {
		return lastnameTeacher;
	}

	public void setLastnameTeacher(String lastnameTeacher) {
		this.lastnameTeacher = lastnameTeacher;
	}

	public String getAddressTeacher() {
		return addressTeacher;
	}

	public void setAddressTeacher(String addressTeacher) {
		this.addressTeacher = addressTeacher;
	}

	public String getSexTeacher() {
		return sexTeacher;
	}

	public void setSexTeacher(String sexTeacher) {
		this.sexTeacher = sexTeacher;
	}

	public String getEmailTeacher() {
		return emailTeacher;
	}

	public void setEmailTeacher(String emailTeacher) {
		this.emailTeacher = emailTeacher;
	}

	public String getPhoneTeacher() {
		return phoneTeacher;
	}

	public void setPhoneTeacher(String phoneTeacher) {
		this.phoneTeacher = phoneTeacher;
	}

	public String getPostboxTeacher() {
		return postboxTeacher;
	}

	public void setPostboxTeacher(String postboxTeacher) {
		this.postboxTeacher = postboxTeacher;
	}

	public String getSerialnumberTeacher() {
		return serialnumberTeacher;
	}

	public void setSerialnumberTeacher(String serialnumberTeacher) {
		this.serialnumberTeacher = serialnumberTeacher;
	}

	public String getIdnumberTeacher() {
		return idnumberTeacher;
	}

	public void setIdnumberTeacher(String idnumberTeacher) {
		this.idnumberTeacher = idnumberTeacher;
	}

	public String getTypeidTeacher() {
		return typeidTeacher;
	}

	public void setTypeidTeacher(String typeidTeacher) {
		this.typeidTeacher = typeidTeacher;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public Collection<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Collection<Subject> subjects) {
		this.subjects = subjects;
	}

	public Collection<Student> getStudents() {
		return students;
	}

	public void setStudents(Collection<Student> students) {
		this.students = students;
	}

	public Teacher(String firstnameTeacher, String lastnameTeacher, String addressTeacher, String sexTeacher,
			String emailTeacher, String phoneTeacher, String postboxTeacher, String serialnumberTeacher,
			String idnumberTeacher, String typeidTeacher, Classroom classroom, Collection<Subject> subjects,
			Collection<Student> students) {
		super();
		this.firstnameTeacher = firstnameTeacher;
		this.lastnameTeacher = lastnameTeacher;
		this.addressTeacher = addressTeacher;
		this.sexTeacher = sexTeacher;
		this.emailTeacher = emailTeacher;
		this.phoneTeacher = phoneTeacher;
		this.postboxTeacher = postboxTeacher;
		this.serialnumberTeacher = serialnumberTeacher;
		this.idnumberTeacher = idnumberTeacher;
		this.typeidTeacher = typeidTeacher;
		this.classroom = classroom;
		this.subjects = subjects;
		this.students = students;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    


}
