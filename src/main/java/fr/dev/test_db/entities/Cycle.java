/**
 * Le cycle du cursus :  1 2 3
 * Il est beaucoup plus spécifique pour le primaire
 */
package fr.dev.test_db.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCycle;
    
    @Column(name = "cyclename", unique = true, length = 15, nullable = false)
    private String nameCycle;

    @OneToMany(mappedBy = "cycle")
    private Collection<Classroom> classrooms;

	public long getIdCycle() {
		return idCycle;
	}

	public void setIdCycle(long idCycle) {
		this.idCycle = idCycle;
	}

	public String getNameCycle() {
		return nameCycle;
	}

	public void setNameCycle(String nameCycle) {
		this.nameCycle = nameCycle;
	}
	
	@JsonIgnore
	public Collection<Classroom> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(Collection<Classroom> classrooms) {
		this.classrooms = classrooms;
	}

	public Cycle(String nameCycle, Collection<Classroom> classrooms) {
		super();
		this.nameCycle = nameCycle;
		this.classrooms = classrooms;
	}

	public Cycle() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
