package fr.musique.service;

import fr.musique.model.Album;
import fr.musique.model.Chanson;
import fr.musique.model.Playlist;

public class ChansonService {

	private DurationService srvDuration;
	
	public void addChansonToAlbum(Chanson c, Album a) {
		
	}
	
	public void addChansonToPlayList(Chanson c, Playlist p) {
		c.getPlaylists().add(p);
		p.getChansons().add(c);
		int duration = srvDuration.calculDureeTotal(p.getChansons());
		p.setDureeTotal(duration);
		
		//sauvegarde de la chanson & la playlist
	}
}