/**
 * Entité désignant la note de l'élève
 */
package fr.dev.test_db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idNote;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(name = "note", columnDefinition = "INT(2)", nullable = false)
    private String note;

    @OneToOne
    @JoinColumn(name = "examination_id")
    private TypeOfExamination examination;

	public long getIdNote() {
		return idNote;
	}

	public void setIdNote(long idNote) {
		this.idNote = idNote;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public TypeOfExamination getExamination() {
		return examination;
	}

	public void setExamination(TypeOfExamination examination) {
		this.examination = examination;
	}

	public Note(Student student, Subject subject, String note, TypeOfExamination examination) {
		super();
		this.student = student;
		this.subject = subject;
		this.note = note;
		this.examination = examination;
	}

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
