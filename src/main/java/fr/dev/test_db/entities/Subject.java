package fr.dev.test_db.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "subject")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSubject;

	@Column(nullable = false, length = 40, name = "name")
	private String nameSubject;

	@Column(nullable = false, name = "gradeoutof", columnDefinition = "INT(2)")
	private String notesurSubject;

	/* Code du cours */
	@Column(nullable = false, name = "codecourse", length = 10)
	private String codecourseSubject;

	@Column(nullable = false, columnDefinition = "INT(1)", name = "coefficient")
	private String coefficientSubject;

	@ManyToOne
	@JoinColumn(name = "teacher_id", nullable = false)
	private Teacher teacher;

	@ManyToOne
	@JoinColumn(name = "classroom_id", nullable = false)
	private Classroom classroom;
	/*
	 * @ManyToMany(mappedBy = "subjects") private Collection<Student> students;
	 */
	@OneToMany(mappedBy = "subject")
	private Set<Note> notes;

	public long getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(long idSubject) {
		this.idSubject = idSubject;
	}

	public String getNameSubject() {
		return nameSubject;
	}

	public void setNameSubject(String nameSubject) {
		this.nameSubject = nameSubject;
	}

	public String getNotesurSubject() {
		return notesurSubject;
	}

	public void setNotesurSubject(String notesurSubject) {
		this.notesurSubject = notesurSubject;
	}

	public String getCodecourseSubject() {
		return codecourseSubject;
	}

	public void setCodecourseSubject(String codecourseSubject) {
		this.codecourseSubject = codecourseSubject;
	}

	public String getCoefficientSubject() {
		return coefficientSubject;
	}

	public void setCoefficientSubject(String coefficientSubject) {
		this.coefficientSubject = coefficientSubject;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@JsonIgnore
	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public Set<Note> getNotes() {
		return notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

	public Subject(String nameSubject, String notesurSubject, String codecourseSubject, String coefficientSubject,
			Teacher teacher, Classroom classroom, Set<Note> notes) {
		super();
		this.nameSubject = nameSubject;
		this.notesurSubject = notesurSubject;
		this.codecourseSubject = codecourseSubject;
		this.coefficientSubject = coefficientSubject;
		this.teacher = teacher;
		this.classroom = classroom;
		this.notes = notes;
	}

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

}
