package fr.diginamic.banque.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.banque.model.Adresse;
import fr.diginamic.banque.model.Banque;
import fr.diginamic.banque.model.Client;
import fr.diginamic.banque.model.Compte;
import fr.diginamic.banque.model.LivretA;
import fr.diginamic.banque.model.Operation;
import fr.diginamic.banque.model.Virement;

public class BanqueMain {

	private static final Logger LOG = LoggerFactory.getLogger(BanqueMain.class);

	public static void main(String[] args) {

		LOG.info("coucou je suis BanqueMain");

		List<Client> clientCreditPatate = new ArrayList<Client>();
		List<Client> clientLivretARobert = new ArrayList<Client>();
		List<Compte> compteDeRobert = new ArrayList<Compte>();

		LocalDateTime date = LocalDateTime.of(2015, 10, 5, 15, 30);
		Adresse rueRobert = new Adresse(20, "rue des cocotier", 41200, "Romorantin-lanthenay");
		Banque creditPatate = new Banque("creditAgricol", clientCreditPatate);

		List<Operation> lesOperations = new ArrayList<Operation>();
		LivretA LivretRobert = new LivretA("FR-0220-3360", 1000.2, clientLivretARobert, lesOperations, 0.6);
		Virement ajout = new Virement(LivretRobert, date, 100.2, "cadeau", "gerome");

		Client robert = new Client("De La Voile", "Robert", LocalDate.of(1995, 12, 20), rueRobert, compteDeRobert,
				creditPatate);

		clientCreditPatate.add(robert);
		clientLivretARobert.add(robert);
		compteDeRobert.add(LivretRobert);

		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("banque-JPA");
		EntityManager EM = EMF.createEntityManager();
		EM.getTransaction().begin();

		EM.persist(creditPatate);
		EM.persist(robert);

		EM.persist(LivretRobert);
		EM.persist(ajout);

		EM.getTransaction().commit();

		EM.close();
		EMF.close();
	}

}
