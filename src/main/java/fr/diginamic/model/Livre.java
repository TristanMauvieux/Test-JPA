package fr.diginamic.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Livre {

	@Id
	private int id;
	@Column(name = "TITRE", length = 255, nullable = true)
	private String titre;

	@Column(name = "AUTEUR", length = 50, nullable = true)
	private String auteur;

	@ManyToMany(mappedBy = "lesLivres")
	private List<Emprunt> emprunt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public List<Emprunt> getEmprunt() {
		return emprunt;
	}

	public void setEmprunt(List<Emprunt> emprunt) {
		this.emprunt = emprunt;
	}

}
