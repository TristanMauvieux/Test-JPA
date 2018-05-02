package fr.diginamic.banque.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Operation {
	@Id
	@GeneratedValue

	private int id;
	@ManyToOne()
	@JoinColumn(name = "ID_compte")
	private Compte compte;
	@Column(name = "DATE")
	private LocalDateTime date;
	@Column(name = "MONTANT")
	private double montant;
	@Column(name = "MOTIF", length = 150, nullable = true)
	private String motif;

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Operation(Compte compte, LocalDateTime date, double montant, String motif) {
		super();
		this.id = id;
		this.compte = compte;
		this.date = date;
		this.montant = montant;
		this.motif = motif;
	}

}
