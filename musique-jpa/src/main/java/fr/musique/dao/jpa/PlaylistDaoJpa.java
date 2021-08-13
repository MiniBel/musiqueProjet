package fr.musique.dao.jpa;

import java.util.List;

import fr.musique.dao.IPlaylistDao;
import fr.musique.model.Playlist;

public class PlaylistDaoJpa extends AbstractDaoJpa<Playlist> implements IPlaylistDao {

	@Override
	public List<Playlist> findAll() {
		return em.createQuery("select p from Playlist p", Playlist.class).getResultList();
	}

	@Override
	public Playlist findById(Integer id) {
		return em.find(Playlist.class, id);
	}

}
