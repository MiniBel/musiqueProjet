package fr.musique.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chanson")
public class Chanson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CHA_ID")
	private int id;

	@Column(name = "CHA_TITRE", length = 100, nullable = false)
	private String titre;

	@Column(name = "CHA_DUREE")
	private int duree;

	private List<Playlist> playlists;

	private List<Genre> genres;
	
	
	
	public Chanson(){
		
	}


	public Chanson(String titre, int duree) {
		super();
		this.titre = titre;
		this.duree = duree;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public int getDuree() {
		return duree;
	}


	public void setDuree(int duree) {
		this.duree = duree;
	}


	public List<Playlist> getPlaylists() {
		return playlists;
	}


	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}


	public List<Genre> getGenres() {
		return genres;
	}


	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	
	
	
	

}
