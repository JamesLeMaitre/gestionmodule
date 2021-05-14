/**
 * Cette désigne l'entité classe
 */
package fr.dev.test_db.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Classroom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idClassroom;

	@Column(nullable = false, length = 35, name = "description")
	private String nameClassroom;

	@Column(nullable = false, length = 7, name = "acronym")
	private String acronymClassroom;

	@Column(nullable = false, columnDefinition = "INT(2)", name = "effective")
	private String effectiveClassroom;

	@Column(name = "seatbench", nullable = false, columnDefinition = "INT(2)")
	private String seatbenchClassroom;

	@Column(name = "schoolfees", columnDefinition = "INT(6)", nullable = false)
	private String schoolfeesClassroom;

	@OneToMany(mappedBy = "classroom")
	private Collection<Student> students;

	@OneToOne(mappedBy = "classroom")
	private Teacher teacher;

	@OneToMany(mappedBy = "classroom")
	private Collection<Subject> subjects;

	@ManyToOne
	@JoinColumn(name = "membership_id", nullable = false)
	private School_membership membership;

	@ManyToOne
	@JoinColumn(name = "cycle_id")
	private Cycle cycle;

	public long getIdClassroom() {
		return idClassroom;
	}

	public void setIdClassroom(long idClassroom) {
		this.idClassroom = idClassroom;
	}

	public String getNameClassroom() {
		return nameClassroom;
	}

	public void setNameClassroom(String nameClassroom) {
		this.nameClassroom = nameClassroom;
	}

	public String getAcronymClassroom() {
		return acronymClassroom;
	}

	public void setAcronymClassroom(String acronymClassroom) {
		this.acronymClassroom = acronymClassroom;
	}

	public String getEffectiveClassroom() {
		return effectiveClassroom;
	}

	public void setEffectiveClassroom(String effectiveClassroom) {
		this.effectiveClassroom = effectiveClassroom;
	}

	public String getSeatbenchClassroom() {
		return seatbenchClassroom;
	}

	public void setSeatbenchClassroom(String seatbenchClassroom) {
		this.seatbenchClassroom = seatbenchClassroom;
	}

	public String getSchoolfeesClassroom() {
		return schoolfeesClassroom;
	}

	public void setSchoolfeesClassroom(String schoolfeesClassroom) {
		this.schoolfeesClassroom = schoolfeesClassroom;
	}
	
	@JsonIgnore
	public Collection<Student> getStudents() {
		return students;
	}

	public void setStudents(Collection<Student> students) {
		this.students = students;
	}
	
	@JsonIgnore
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	@JsonIgnore
	public Collection<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Collection<Subject> subjects) {
		this.subjects = subjects;
	}

	public School_membership getMembership() {
		return membership;
	}

	public void setMembership(School_membership membership) {
		this.membership = membership;
	}

	public Cycle getCycle() {
		return cycle;
	}

	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}

	public Classroom(String nameClassroom, String acronymClassroom, String effectiveClassroom,
			String seatbenchClassroom, String schoolfeesClassroom, Collection<Student> students, Teacher teacher,
			Collection<Subject> subjects, School_membership membership, Cycle cycle) {
		super();
		this.nameClassroom = nameClassroom;
		this.acronymClassroom = acronymClassroom;
		this.effectiveClassroom = effectiveClassroom;
		this.seatbenchClassroom = seatbenchClassroom;
		this.schoolfeesClassroom = schoolfeesClassroom;
		this.students = students;
		this.teacher = teacher;
		this.subjects = subjects;
		this.membership = membership;
		this.cycle = cycle;
	}

	public Classroom() {
		super();
		// TODO Auto-generated constructor stub
	}

}
