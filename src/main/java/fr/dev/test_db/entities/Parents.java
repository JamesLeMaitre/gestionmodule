/** 
 * La classe parents des élèves
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
public class Parents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idParents;

    @Column(name = "fistnamefather", nullable = false, length = 15)
    private String firstnameFather;

    @Column(name = "lastnamefather", nullable = false, length = 15)
    private String lastnameFather;

    @Column(name = "professionfather", nullable = false, length = 15)
    private String professionFather;

    @Column(name = "addressfather", nullable = false, length = 15)
    private String addressFather;

    @Column(name = "emailfather", nullable = false, length = 35)
    private String emailFather;

    @Column(name = "phonefather", nullable = false, columnDefinition = "INT(8)")
    private String phoneFather;

    @Column(name = "photofather", nullable = false, length = 15)
    private String photoFather;

    @Column(name = "fistnamemother", nullable = false, length = 15)
    private String firstnameMother;

    @Column(name = "lastnamemother", nullable = false, length = 15)
    private String lastnameMother;

    @Column(name = "professionmother", nullable = false, length = 15)
    private String professionMother;

    @Column(name = "addressmother", nullable = false, length = 15)
    private String addressMother;

    @Column(name = "emailmother", nullable = false, length = 35)
    private String emailMother;

    @Column(name = "phonemother", nullable = false, columnDefinition = "INT(8)")
    private String phoneMother;

    @Column(name = "photomother", nullable = false, length = 15)
    private String photoMother;

    @OneToMany(mappedBy = "parents")
    private Collection<Student> students;

	public long getIdParents() {
		return idParents;
	}

	public void setIdParents(long idParents) {
		this.idParents = idParents;
	}

	public String getFirstnameFather() {
		return firstnameFather;
	}

	public void setFirstnameFather(String firstnameFather) {
		this.firstnameFather = firstnameFather;
	}

	public String getLastnameFather() {
		return lastnameFather;
	}

	public void setLastnameFather(String lastnameFather) {
		this.lastnameFather = lastnameFather;
	}

	public String getProfessionFather() {
		return professionFather;
	}

	public void setProfessionFather(String professionFather) {
		this.professionFather = professionFather;
	}

	public String getAddressFather() {
		return addressFather;
	}

	public void setAddressFather(String addressFather) {
		this.addressFather = addressFather;
	}

	public String getEmailFather() {
		return emailFather;
	}

	public void setEmailFather(String emailFather) {
		this.emailFather = emailFather;
	}

	public String getPhoneFather() {
		return phoneFather;
	}

	public void setPhoneFather(String phoneFather) {
		this.phoneFather = phoneFather;
	}

	public String getPhotoFather() {
		return photoFather;
	}

	public void setPhotoFather(String photoFather) {
		this.photoFather = photoFather;
	}

	public String getFirstnameMother() {
		return firstnameMother;
	}

	public void setFirstnameMother(String firstnameMother) {
		this.firstnameMother = firstnameMother;
	}

	public String getLastnameMother() {
		return lastnameMother;
	}

	public void setLastnameMother(String lastnameMother) {
		this.lastnameMother = lastnameMother;
	}

	public String getProfessionMother() {
		return professionMother;
	}

	public void setProfessionMother(String professionMother) {
		this.professionMother = professionMother;
	}

	public String getAddressMother() {
		return addressMother;
	}

	public void setAddressMother(String addressMother) {
		this.addressMother = addressMother;
	}

	public String getEmailMother() {
		return emailMother;
	}

	public void setEmailMother(String emailMother) {
		this.emailMother = emailMother;
	}

	public String getPhoneMother() {
		return phoneMother;
	}

	public void setPhoneMother(String phoneMother) {
		this.phoneMother = phoneMother;
	}

	public String getPhotoMother() {
		return photoMother;
	}

	public void setPhotoMother(String photoMother) {
		this.photoMother = photoMother;
	}
	
	@JsonIgnore
	public Collection<Student> getStudents() {
		return students;
	}

	public void setStudents(Collection<Student> students) {
		this.students = students;
	}

	public Parents(String firstnameFather, String lastnameFather, String professionFather, String addressFather,
			String emailFather, String phoneFather, String photoFather, String firstnameMother, String lastnameMother,
			String professionMother, String addressMother, String emailMother, String phoneMother, String photoMother,
			Collection<Student> students) {
		super();
		this.firstnameFather = firstnameFather;
		this.lastnameFather = lastnameFather;
		this.professionFather = professionFather;
		this.addressFather = addressFather;
		this.emailFather = emailFather;
		this.phoneFather = phoneFather;
		this.photoFather = photoFather;
		this.firstnameMother = firstnameMother;
		this.lastnameMother = lastnameMother;
		this.professionMother = professionMother;
		this.addressMother = addressMother;
		this.emailMother = emailMother;
		this.phoneMother = phoneMother;
		this.photoMother = photoMother;
		this.students = students;
	}

	public Parents() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
