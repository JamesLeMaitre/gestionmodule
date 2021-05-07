/**
 * Cette table coorrespond à la sauvegarde de l'année académique
 */
package fr.dev.test_db.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Academical {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAcademical;

	@Column(name = "academicyear", nullable = false, length = 11)
	private String academicyear;

	@Column(name = "isActive", columnDefinition = "boolean default false")
	private String isActive;

	@OneToMany(mappedBy = "academical")
	private Collection<Registration> registrations;

	@OneToMany(mappedBy = "academical")
	private Collection<School> schools;

	public long getIdAcademical() {
		return idAcademical;
	}

	public void setIdAcademical(long idAcademical) {
		this.idAcademical = idAcademical;
	}

	public String getAcademicyear() {
		return academicyear;
	}

	public void setAcademicyear(String academicyear) {
		this.academicyear = academicyear;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Collection<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(Collection<Registration> registrations) {
		this.registrations = registrations;
	}

	public Collection<School> getSchools() {
		return schools;
	}

	public void setSchools(Collection<School> schools) {
		this.schools = schools;
	}

	public Academical(String academicyear, String isActive, Collection<Registration> registrations,
			Collection<School> schools) {
		super();
		this.academicyear = academicyear;
		this.isActive = isActive;
		this.registrations = registrations;
		this.schools = schools;
	}

	public Academical() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
