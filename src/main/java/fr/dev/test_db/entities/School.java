/**
 * Type d'ecole à créer : primaire, college, lycee
 * LevelSchool : Type d'école
 */
package fr.dev.test_db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author James
 */
@Entity
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSchool;
	
	@Column(name = "schoolname", length = 35)
	private String schoolname;
	
	@Column(name = "levelschool", nullable = false, length = 35)
	private String levelSchool;
	
	@Column(name = "motto", length = 50, nullable = false)
	private String mottoSchool;
	
	@Column(name = "logo", nullable = false)
	private String logoSchool;
	
	@Column(name = "creationdate", nullable = false, length = 15)
	private String creationdateSchool;
	
	@Column(name = "foundername", nullable = false, length = 20)
	private String founderSchool;
	
	@Column(name = "generalmanager", nullable = false, length = 25)
	private String generalmanagerSchool;
	
	@Column(name = "email", nullable = false, length = 35)
	private String emailSchool;
	
	@Column(nullable = false, name = "phone", length = 8)
	private String phoneSchool;

	@ManyToOne
    @JoinColumn(name = "academical_id", nullable = false)
    private Academical academical;
	
	public long getIdSchool() {
		return idSchool;
	}

	public void setIdSchool(long idSchool) {
		this.idSchool = idSchool;
	}

	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public String getLevelSchool() {
		return levelSchool;
	}

	public void setLevelSchool(String levelSchool) {
		this.levelSchool = levelSchool;
	}

	public String getMottoSchool() {
		return mottoSchool;
	}

	public void setMottoSchool(String mottoSchool) {
		this.mottoSchool = mottoSchool;
	}

	public String getLogoSchool() {
		return logoSchool;
	}

	public void setLogoSchool(String logoSchool) {
		this.logoSchool = logoSchool;
	}

	public String getCreationdateSchool() {
		return creationdateSchool;
	}

	public void setCreationdateSchool(String creationdateSchool) {
		this.creationdateSchool = creationdateSchool;
	}

	public String getFounderSchool() {
		return founderSchool;
	}

	public void setFounderSchool(String founderSchool) {
		this.founderSchool = founderSchool;
	}

	public String getGeneralmanagerSchool() {
		return generalmanagerSchool;
	}

	public void setGeneralmanagerSchool(String generalmanagerSchool) {
		this.generalmanagerSchool = generalmanagerSchool;
	}

	public String getEmailSchool() {
		return emailSchool;
	}

	public void setEmailSchool(String emailSchool) {
		this.emailSchool = emailSchool;
	}

	public String getPhoneSchool() {
		return phoneSchool;
	}

	public void setPhoneSchool(String phoneSchool) {
		this.phoneSchool = phoneSchool;
	}

	public Academical getAcademical() {
		return academical;
	}

	public void setAcademical(Academical academical) {
		this.academical = academical;
	}

	public School(String schoolname, String levelSchool, String mottoSchool, String logoSchool,
			String creationdateSchool, String founderSchool, String generalmanagerSchool, String emailSchool,
			String phoneSchool, Academical academical) {
		super();
		this.schoolname = schoolname;
		this.levelSchool = levelSchool;
		this.mottoSchool = mottoSchool;
		this.logoSchool = logoSchool;
		this.creationdateSchool = creationdateSchool;
		this.founderSchool = founderSchool;
		this.generalmanagerSchool = generalmanagerSchool;
		this.emailSchool = emailSchool;
		this.phoneSchool = phoneSchool;
		this.academical = academical;
	}

	public School() {
		super();
		// TODO Auto-generated constructor stub
	}

}
