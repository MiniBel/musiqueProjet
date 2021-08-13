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
@Table(name = "playlist")
public class Playlist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLA_ID")
	private int id;

	@Column(name = "PLA_NOM", length = 100, nullable = false)
	private String nom;

	@Column(name = "PLA_DUREE_TOTAL")
	private int dureeTotal;

	@ManyToMany
	@JoinTable(name = "pla_cha", joinColumns = @JoinColumn(name = "IDPLAYLIST", referencedColumnName = "PLA_ID") , inverseJoinColumns = @JoinColumn(name = "IDCHANSON", referencedColumnName = "CHA_ID") , uniqueConstraints = @UniqueConstraint(columnNames = {
			"IDPLAYLIST", "IDCHANSON" }) )
	private List<Chanson> chansons;

	@ManyToOne
	@JoinColumn(name = "PLA_COMPTE_ID")
	private Compte compte;

	public Playlist() {
		super();
	}

	public Playlist(String nom) {
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

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}
