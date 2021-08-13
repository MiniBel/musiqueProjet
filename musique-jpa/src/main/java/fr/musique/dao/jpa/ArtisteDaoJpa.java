package fr.musique.dao.jpa;

import java.util.List;

import fr.musique.dao.IArtisteDao;
import fr.musique.model.Artiste;

public class ArtisteDaoJpa extends AbstractDaoJpa<Artiste> implements IArtisteDao {

	@Override
	public List<Artiste> findAll() {
		return em.createQuery("select a from Artiste a", Artiste.class).getResultList();
	}

	@Override
	public Artiste findById(Integer id) {
		return em.find(Artiste.class, id);
	}

	@Override
	public Artiste findByName(String nom) {
		return em.createQuery("select a from Artiste a where a.nom = ?1", Artiste.class).setParameter(1, nom).getSingleResult();
	}

}
