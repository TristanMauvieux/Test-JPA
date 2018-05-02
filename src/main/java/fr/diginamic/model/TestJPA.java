package fr.diginamic.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJPA {

	private static final Logger LOG = LoggerFactory.getLogger(TestJPA.class);

	public static void main(String[] args) {

		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("essai-JPA");
		EntityManager EM = EMF.createEntityManager();
		EM.getTransaction().begin();
		Livre coucou = EM.find(Livre.class, 1);
		Query query = EM.createQuery("from Emprunt where ID = 3");
		Emprunt emprunt = (Emprunt) query.getSingleResult();
		LOG.info("##########################******************************#############################");

		for (Livre livre : emprunt.getLesLivres()) {
			LOG.info("titre" + livre.getTitre() + " auteur " + livre.getAuteur());
		}
		LOG.info("##########################********FIN LIVRE**********************#############################");

		Query queryClient = EM.createQuery("from Client where ID =1");
		Client antoine = (Client) queryClient.getSingleResult();
		LOG.info("##########################******************************#############################");
		for (Emprunt emp : antoine.getEmprunt()) {
			for (Livre livre : emp.getLesLivres()) {
				LOG.info("le client " + antoine.getNom() + " a Emprunté " + livre.getTitre());
			}
		}
		LOG.info("##########################*********FIN CLIENT*********************#############################");

		EM.close();
		EMF.close();

		LOG.info(coucou.getTitre() + " est le titre à succes de l'auteur " + coucou.getAuteur());

	}

}
