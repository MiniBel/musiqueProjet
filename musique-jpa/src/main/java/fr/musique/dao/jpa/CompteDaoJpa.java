package fr.musique.dao.jpa;

import java.util.List;

import fr.musique.dao.ICompteDao;
import fr.musique.model.Compte;

public class CompteDaoJpa extends AbstractDaoJpa<Compte> implements ICompteDao {

	@Override
	public List<Compte> findAll() {
		return em
				.createQuery("select c from Compte c", Compte.class)
				.getResultList();
	}

	@Override
	public Compte findById(Integer id) {
		return em.find(Compte.class, id);
	}

}
