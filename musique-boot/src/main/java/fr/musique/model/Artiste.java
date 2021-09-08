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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "artiste")
public class Artiste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ART_ID")
	private int id;

	@Column(name = "ART_NOM", length = 100, nullable = false)
	private String nom;

	@ManyToMany
	@JoinTable(name = "art_gen", joinColumns = @JoinColumn(name = "IDARTISTE", referencedColumnName = "ART_ID") , inverseJoinColumns = @JoinColumn(name = "IDGENRE", referencedColumnName = "GEN_ID") , uniqueConstraints = @UniqueConstraint(columnNames = {
			"IDARTISTE", "IDGENRE" }) )
	private List<Genre> genres;

	@ManyToMany(mappedBy = "artistes")
	private List<Album> albums;

	public Artiste() {

	}

	public Artiste(String nom) {
		super();
		this.nom = nom;
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

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

}
