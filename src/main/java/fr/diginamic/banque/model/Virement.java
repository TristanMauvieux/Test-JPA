package fr.diginamic.banque.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Virement extends Operation {
	/*
	 * @Id
	 * 
	 * @GeneratedValue private int id;
	 */
	@Column(name = "BENEFICIAIRE", length = 150, nullable = true)
	private String beneficiaire;

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public Virement(Compte compte, LocalDateTime date, double montant, String motif, String beneficiaire) {
		super(compte, date, montant, motif);
		this.beneficiaire = beneficiaire;
	}
}
