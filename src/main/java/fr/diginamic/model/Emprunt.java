package fr.diginamic.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * create table EMPRUNT (ID integer(10) NOT NULL PRIMARY KEY, DATE_DEBUT
 * DATETIME NOT NULL, DATE_FIN DATETIME, DELAI integer(10), ID_CLIENT
 * integer(10) not null);
 * 
 * @author diginamic02
 *
 */
@Entity
public class Emprunt {
	@Id
	private int id;
	@Column(name = "DATE_DEBUT")
	private Date dateDebut;
	@Column(name = "DELAI")
	private int delai;
	@Column(name = "DATE_FIN")
	private Date dateFin;

	@ManyToOne
	@JoinColumn(name = "ID_CLIENT")
	private Client client;

	@ManyToMany
	@JoinTable(name = "COMPO", joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))
	private List<Livre> lesLivres;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Livre> getLesLivres() {
		return lesLivres;
	}

	public void setLesLivres(List<Livre> lesLivres) {
		this.lesLivres = lesLivres;
	}
}
