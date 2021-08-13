package fr.musique.dao.jpa;

import java.util.List;

import fr.musique.dao.IAlbumDao;
import fr.musique.model.Album;
import fr.musique.service.DurationService;

public class AlbumDaoJpa extends AbstractDaoJpa<Album> implements IAlbumDao{
	private DurationService srvDuration = new DurationService();

	@Override
	public List<Album> findAll() {
		return em.createQuery("select a from Album a", Album.class).getResultList();
	}

	@Override
	public Album findById(Integer id) {
		return em.find(Album.class, id);
	}
	
	@Override
	public Album save(Album entity) {
		int dureeTotal = srvDuration.calculDureeTotal( entity.getChansons() );
		
		entity.setDureeTotal(dureeTotal);
		
		return super.save(entity);
	}

}
