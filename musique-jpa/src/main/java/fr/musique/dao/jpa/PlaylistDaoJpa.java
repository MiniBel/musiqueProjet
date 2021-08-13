package fr.musique.dao.jpa;

import java.util.List;

import fr.musique.dao.IPlaylistDao;
import fr.musique.model.Playlist;
import fr.musique.service.DurationService;

public class PlaylistDaoJpa extends AbstractDaoJpa<Playlist> implements IPlaylistDao {
	private DurationService srvDuration = new DurationService();

	@Override
	public List<Playlist> findAll() {
		return em.createQuery("select p from Playlist p", Playlist.class).getResultList();
	}

	@Override
	public Playlist findById(Integer id) {
		return em.find(Playlist.class, id);
	}

	@Override
	public Playlist save(Playlist entity) {
		int dureeTotal = srvDuration.calculDureeTotal(entity.getChansons());

		entity.setDureeTotal(dureeTotal);
		return super.save(entity);
	}

}
