/**
 * 
 */
package fr.narbonneau.mpl.locataire.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author paulo
 *
 */
@Table
@Entity
public class Locataire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(nullable = false)
	private String qualite;
	
	@Column(nullable = false)
	private String nom;
	
	@Column
	private String email;
	
	

}
