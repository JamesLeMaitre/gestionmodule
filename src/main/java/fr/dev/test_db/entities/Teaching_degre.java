/**
 * Dégré d'enseignemant : Premier ou deuxième degré
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
public class Teaching_degre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDegre;
    
    @Column(name = "orderdegre", unique = true, nullable = false, length = 15)
    private String orderDegre;

    @OneToMany(mappedBy = "degre")
    private Collection<School_membership> memberships;

	public long getIdDegre() {
		return idDegre;
	}

	public void setIdDegre(long idDegre) {
		this.idDegre = idDegre;
	}

	public String getOrderDegre() {
		return orderDegre;
	}

	public void setOrderDegre(String orderDegre) {
		this.orderDegre = orderDegre;
	}

	public Collection<School_membership> getMemberships() {
		return memberships;
	}

	public void setMemberships(Collection<School_membership> memberships) {
		this.memberships = memberships;
	}

	public Teaching_degre(String orderDegre, Collection<School_membership> memberships) {
		super();
		this.orderDegre = orderDegre;
		this.memberships = memberships;
	}

	public Teaching_degre() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
