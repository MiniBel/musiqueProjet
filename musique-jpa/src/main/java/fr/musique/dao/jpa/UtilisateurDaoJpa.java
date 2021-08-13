package fr.musique.dao.jpa;

import java.util.List;

import fr.musique.dao.IUtilisateurDao;
import fr.musique.model.Utilisateur;

public class UtilisateurDaoJpa extends AbstractDaoJpa<Utilisateur> implements IUtilisateurDao{

	@Override
	public List<Utilisateur> findAll() {
		return em
				.createQuery("select u from Utilisateur u", Utilisateur.class)
				.getResultList();
	}

	@Override
	public Utilisateur findById(Integer id) {
		return em.find(Utilisateur.class, id);
	}



}
