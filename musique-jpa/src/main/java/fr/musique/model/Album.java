package fr.musique.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "album")
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ALB_ID")
	private int id;

	@Column(name = "ALB_NOM", length = 100, nullable = false)
	private String nom;

	@Column(name = "ALB_DATE_PARUTION")
	private LocalDate dateParution;

	@Column(name = "ALB_DUREE_TOTAL")
	private int dureeTotal;

	private List<Chanson> chansons;

	private List<Playlist> playlists;

	private List<Genre> genres;
	
	
	public Album(){
		
	}


	public Album(String nom, LocalDate dateParution, int dureeTotal) {
		super();
		this.nom = nom;
		this.dateParution = dateParution;
		this.dureeTotal = dureeTotal;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public LocalDate getDateParution() {
		return dateParution;
	}


	public void setDateParution(LocalDate dateParution) {
		this.dateParution = dateParution;
	}


	public int getDureeTotal() {
		return dureeTotal;
	}


	public void setDureeTotal(int dureeTotal) {
		this.dureeTotal = dureeTotal;
	}


	public List<Chanson> getChansons() {
		return chansons;
	}


	public void setChansons(List<Chanson> chansons) {
		this.chansons = chansons;
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
