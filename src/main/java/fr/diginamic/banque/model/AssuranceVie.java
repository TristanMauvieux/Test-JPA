package fr.diginamic.banque.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class AssuranceVie extends Compte {
	/*
	 * @Id
	 * 
	 * @GeneratedValue private int id;
	 */
	@Column(name = "DATE_FIN", nullable = true)
	private LocalDate dateFin;

	@Column(name = "TAUX", nullable = true)
	private double taux;

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public AssuranceVie(String numero, double solde, List<Client> client, List<Operation> operations, LocalDate dateFin,
			double taux) {
		super(numero, solde, client, operations);
		this.dateFin = dateFin;
		this.taux = taux;
	}

}
