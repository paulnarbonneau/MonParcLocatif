package fr.narbonneau.mpl.biens.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Biens {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long idBien;
	
	@Column(nullable = false, unique = true)
	private long idProprietaire;
	
	@Column
	private long idLocataire;
	
	@Column
	private String adresse1;
	
	@Column
	private String adresse2;
	
	@Column
	private String codePostal;
	
	@Column
	private String ville;
	
	@Column
	private BigDecimal loyer;
}
