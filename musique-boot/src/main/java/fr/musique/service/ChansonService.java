package fr.musique.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import fr.musique.dao.IAlbumDaoJpaRepository;
import fr.musique.dao.IArtisteDaoJpaRepository;
import fr.musique.dao.IChansonDaoJpaRepository;
import fr.musique.dao.IPlaylistDaoJpaRepository;
import fr.musique.model.Album;
import fr.musique.model.Artiste;
import fr.musique.model.Chanson;
import fr.musique.model.Playlist;

@Service
public class ChansonService {

	@Autowired
	private DurationService srvDuration;

	@Autowired
	private IChansonDaoJpaRepository daoChanson;

	@Autowired
	private IAlbumDaoJpaRepository daoAlbum;

	@Autowired
	private IPlaylistDaoJpaRepository daoPlaylist;

	@Autowired
	private IArtisteDaoJpaRepository daoArtiste;

	public void addChansonToAlbum(Chanson c, Album a) {
		if (c.getAlbums() == null) {
			c.setAlbums(new ArrayList<>());
		}
		
		c.getAlbums().add(a);
		
		c = daoChanson.save(c);
		
		if (a.getChansons() == null) {
			a.setChansons(new ArrayList<>());
		}
		
		a.getChansons().add(c);
		int duration = srvDuration.calculDureeTotal(a.getChansons());
		a.setDureeTotal(duration);
		
		int nombreChanson = srvDuration.CalculNombreChanson(a.getChansons());
		a.setNombreChanson(nombreChanson);

		a = daoAlbum.save(a);
		

	}

	public void addChansonToPlayList(Chanson c, Playlist p) {
		if (c.getPlaylists() == null){
			c.setPlaylists(new ArrayList<>());
		}
	
		c.getPlaylists().add(p);
		
		if(p.getChansons() == null){
			p.setChansons(new ArrayList<>());
		}
		
		p.getChansons().add(c);
		int duration = srvDuration.calculDureeTotal(p.getChansons());
		p.setDureeTotal(duration);
		
		int nombreChanson = srvDuration.CalculNombreChanson(p.getChansons());
		p.setNombreChanson(nombreChanson);

		// sauvegarde de la chanson & la playlist
		c = daoChanson.save(c);
		p = daoPlaylist.save(p);
	}

	public void removeChansonToPlayList(Chanson c, Playlist p) {
		if (c.getPlaylists() == null){
			c.setPlaylists(new ArrayList<>());
		}
	
		c.getPlaylists().remove(p);
		
		if(p.getChansons() == null){
			p.setChansons(new ArrayList<>());
		}
		
		p.getChansons().remove(c);
		int duration = srvDuration.calculDureeTotal(p.getChansons());
		p.setDureeTotal(duration);
		
		int nombreChanson = srvDuration.CalculNombreChanson(p.getChansons());
		p.setNombreChanson(nombreChanson);

		// sauvegarde de la chanson & la playlist
		c = daoChanson.save(c);
		p = daoPlaylist.save(p);
	}

	public void addArtisteToALbum(Album album, Artiste artiste) {
		if (album.getArtistes() == null){
			album.setArtistes(new ArrayList<>());
		}

		album.getArtistes().add(artiste);

		if (artiste.getAlbums() == null){
			artiste.setAlbums(new ArrayList<>());
		}

		artiste.getAlbums().add(album);

		artiste = daoArtiste.save(artiste);
		album = daoAlbum.save(album);

	}
}