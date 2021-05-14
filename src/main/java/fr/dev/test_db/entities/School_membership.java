/**
 * Appartenance à l'école : Maternelle, Primaire, Collège et Lycée
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class School_membership {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long idMembership;

	@Column(name = "libelle", unique = true, length = 12, nullable = false)
	private String nameMembership;

	@ManyToOne
	@JoinColumn(name = "teachdegre_id", nullable = false)
	private Teaching_degre degre;

	@OneToMany(mappedBy = "membership")
	private Collection<Classroom> classrooms;

	public long getIdMembership() {
		return idMembership;
	}

	public void setIdMembership(long idMembership) {
		this.idMembership = idMembership;
	}

	public String getNameMembership() {
		return nameMembership;
	}

	public void setNameMembership(String nameMembership) {
		this.nameMembership = nameMembership;
	}

	public Teaching_degre getDegre() {
		return degre;
	}

	public void setDegre(Teaching_degre degre) {
		this.degre = degre;
	}

	@JsonIgnore
	public Collection<Classroom> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(Collection<Classroom> classrooms) {
		this.classrooms = classrooms;
	}

	public School_membership(String nameMembership, Teaching_degre degre, Collection<Classroom> classrooms) {
		super();
		this.nameMembership = nameMembership;
		this.degre = degre;
		this.classrooms = classrooms;
	}

	public School_membership() {
		super();
		// TODO Auto-generated constructor stub
	}

}
