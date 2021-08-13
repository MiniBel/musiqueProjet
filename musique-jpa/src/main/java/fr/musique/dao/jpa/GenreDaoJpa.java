package fr.musique.dao.jpa;

import java.util.List;

import fr.musique.dao.IGenreDao;
import fr.musique.model.Genre;

public class GenreDaoJpa extends AbstractDaoJpa<Genre> implements IGenreDao {

	@Override
	public List<Genre> findAll() {

		return em.createQuery("select g from Genre g", Genre.class).getResultList();
	}

	@Override
	public Genre findById(Integer id) {

		return em.find(Genre.class, id);
	}

	@Override
	public Genre findByName(String nom) {
		return em.createQuery("select g from Genre g where g.nom = ?1", Genre.class).setParameter(1, nom)
				.getSingleResult();
	}

}
