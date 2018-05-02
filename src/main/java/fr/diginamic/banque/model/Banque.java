package fr.diginamic.banque.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Banque {

	@Id
	@GeneratedValue

	private int id;
	@Column(name = "NOM", length = 100, nullable = true)
	private String nom;

	@OneToMany(mappedBy = "banque")
	private List<Client> client;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Client> getClient() {
		return client;
	}

	public void setClient(List<Client> client) {
		this.client = client;
	}

	public Banque() {

	}

	public Banque(String nom, List<Client> client) {
		super();

		this.nom = nom;
		this.client = client;
	}

}
