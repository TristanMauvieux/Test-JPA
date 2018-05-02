package fr.diginamic.banque.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "NUMERO", length = 60, nullable = true)
	private String numero;

	@Column(name = "SOLDE", nullable = true)
	private double solde;

	@ManyToMany
	@JoinTable(name = "CLIENT_COMPTE", joinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID"))
	private List<Client> client;

	@OneToMany(mappedBy = "compte")
	private List<Operation> operations;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
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

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public Compte() {

	}

	public Compte(String numero, double solde, List<Client> client, List<Operation> operations) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.client = client;
		this.operations = operations;
	}

}
