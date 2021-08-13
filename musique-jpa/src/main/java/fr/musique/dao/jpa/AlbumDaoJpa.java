package fr.musique.dao.jpa;

import java.util.List;

import fr.musique.dao.IAlbumDao;
import fr.musique.model.Album;

public class AlbumDaoJpa extends AbstractDaoJpa<Album> implements IAlbumDao{

	@Override
	public List<Album> findAll() {
		return em.createQuery("select a from Album a", Album.class).getResultList();
	}

	@Override
	public Album findById(Integer id) {
		return em.find(Album.class, id);
	}

}
