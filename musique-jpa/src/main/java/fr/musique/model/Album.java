package fr.musique.model;

import java.time.LocalDate;
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

	@ManyToMany
	@JoinTable(name = "alb_art", joinColumns = @JoinColumn(name = "IDALBUM", referencedColumnName = "ALB_ID") , inverseJoinColumns = @JoinColumn(name = "IDARTISTE", referencedColumnName = "ART_ID") , uniqueConstraints = @UniqueConstraint(columnNames = {
			"IDALBUM", "IDARTISTE" }) )
	private List<Artiste> artistes;

	@ManyToMany(mappedBy = "albums")
	private List<Chanson> chansons;

	@ManyToMany
	@JoinTable(name = "alb_gen", joinColumns = @JoinColumn(name = "IDALBUM", referencedColumnName = "ALB_ID") , inverseJoinColumns = @JoinColumn(name = "IDGENRE", referencedColumnName = "GEN_ID") , uniqueConstraints = @UniqueConstraint(columnNames = {
			"IDALBUM", "IDGENRE" }) )
	private List<Genre> genres;

	public Album() {

	}

	public Album(String nom, LocalDate dateParution) {
		super();
		this.nom = nom;
		this.dateParution = dateParution;
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

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<Artiste> getArtistes() {
		return artistes;
	}

	public void setArtistes(List<Artiste> artistes) {
		this.artistes = artistes;
	}

}
