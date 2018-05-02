package fr.diginamic.banque.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Client {

	@Id
	@GeneratedValue
	private int id;
	@Column(name = "NOM", length = 60, nullable = true)
	private String nom;
	@Column(name = "PRENOM", length = 60, nullable = true)
	private String prenom;
	@Column(name = "DATE_DE_NAISSANCE", length = 60)
	private LocalDate dateDeNaissance;
	@Embedded
	private Adresse adresse;

	@ManyToMany(mappedBy = "client")
	private List<Compte> compte;

	@ManyToOne
	@JoinColumn(name = "ID_BANQUE")
	private Banque banque;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Compte> getCompte() {
		return compte;
	}

	public void setCompte(List<Compte> compte) {
		this.compte = compte;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public Client() {

	}

	public Client(String nom, String prenom, LocalDate dateDeNaissance, Adresse adresse, List<Compte> compte,
			Banque banque) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.compte = compte;
		this.banque = banque;
	}

}
