package fr.musique.dao.jpa;

import java.util.List;

import fr.musique.dao.IChansonDao;
import fr.musique.model.Chanson;

public class ChansonDaoJpa extends AbstractDaoJpa<Chanson> implements IChansonDao {

	@Override
	public List<Chanson> findAll() {

		return em.createQuery("select c from Chanson c", Chanson.class).getResultList();
	}

	@Override
	public Chanson findById(Integer id) {

		return em.find(Chanson.class, id);
	}

	@Override
	public Chanson findByName(String nom) {
		return em.createQuery("select c from Chanson c where c.titre = ?1", Chanson.class).setParameter(1, nom)
				.getSingleResult();
	}

}
