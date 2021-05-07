/**
 * Le type d'examen : Mensuel ou Trimestriel Semestriel
 */
package fr.dev.test_db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author James
 */
@Entity
public class TypeOfExamination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTypeexamination;

    @Column(name = "nature", nullable = false, length = 25)
    private String natureTypeexamination;

    @Column(name = "monthexamination", nullable = false, length = 15)
    private String monthTypeexamination;

	public long getIdTypeexamination() {
		return idTypeexamination;
	}

	public void setIdTypeexamination(long idTypeexamination) {
		this.idTypeexamination = idTypeexamination;
	}

	public String getNatureTypeexamination() {
		return natureTypeexamination;
	}

	public void setNatureTypeexamination(String natureTypeexamination) {
		this.natureTypeexamination = natureTypeexamination;
	}

	public String getMonthTypeexamination() {
		return monthTypeexamination;
	}

	public void setMonthTypeexamination(String monthTypeexamination) {
		this.monthTypeexamination = monthTypeexamination;
	}

	public TypeOfExamination(String natureTypeexamination, String monthTypeexamination) {
		super();
		this.natureTypeexamination = natureTypeexamination;
		this.monthTypeexamination = monthTypeexamination;
	}

	public TypeOfExamination() {
		super();
		// TODO Auto-generated constructor stub
	}

}
