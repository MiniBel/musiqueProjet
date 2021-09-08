package fr.musique.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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

	@ManyToMany
	@JoinTable(name = "cha_alb", joinColumns = @JoinColumn(name = "IDCHANSON", referencedColumnName = "CHA_ID") , inverseJoinColumns = @JoinColumn(name = "IDALBUM", referencedColumnName = "ALB_ID") , uniqueConstraints = @UniqueConstraint(columnNames = {
			"IDCHANSON", "IDALBUM" }) )
	private List<Album> albums;

	@ManyToMany(mappedBy = "chansons")
	private List<Playlist> playlists;

	@ManyToOne
	@JoinColumn(name = "CHA_GENRE_ID")
	private Genre genre;

	public Chanson() {

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

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

}
