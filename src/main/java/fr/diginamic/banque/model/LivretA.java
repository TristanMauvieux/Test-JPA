package fr.diginamic.banque.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity

public class LivretA extends Compte {

	/*
	 * @Id
	 * 
	 * @GeneratedValue private int id;
	 */
	@Column(name = "TAUX", nullable = true)
	private double taux;

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public LivretA(String numero, double solde, List<Client> client, List<Operation> operations, double taux) {
		super(numero, solde, client, operations);
		this.taux = taux;
	}

}
