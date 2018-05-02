package fr.diginamic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Jeux {

	@Id
	private int id;

	@Column(name = "NOM", length = 30, nullable = false, unique = false)
	private String nom;

	@Column(name = "GENRE", length = 30, nullable = true, unique = false)
	private String genre;

	public Jeux(int id, String nom, String genre) {
		this.id = id;
		this.nom = nom;
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
