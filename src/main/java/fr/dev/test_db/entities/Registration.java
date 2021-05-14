/**
 * Table inscription académique des élèves
 */
package fr.dev.test_db.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author James
 */
@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRegistration;


    @ManyToOne
    @JoinColumn(name = "academical_id", nullable = false)
    private Academical academical;

    @OneToMany(mappedBy = "registration")
    private Collection<Student> students;

	public long getIdRegistration() {
		return idRegistration;
	}

	public void setIdRegistration(long idRegistration) {
		this.idRegistration = idRegistration;
	}

	public Academical getAcademical() {
		return academical;
	}

	public void setAcademical(Academical academical) {
		this.academical = academical;
	}

	@JsonIgnore
	public Collection<Student> getStudents() {
		return students;
	}

	public void setStudents(Collection<Student> students) {
		this.students = students;
	}

	public Registration(Academical academical, Collection<Student> students) {
		super();
		this.academical = academical;
		this.students = students;
	}

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
