package fr.musique.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "compte")
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COM_ID")
	private int id;

	@Column(name = "COM_EMAIL", length = 50, nullable = false)
	private String email;

	@Column(name = "COM_PASSWORD", length = 50, nullable = false)
	private String password;

	@ManyToOne
	@JoinColumn (name = "COM_UTILISATEUR_ID")
	private Utilisateur utilisateur;

	
	private List<Playlist> playlists;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}

	public Compte() {
	}

	public Compte(String email, String password) {
		this.email = email;
		this.password = password;
	}

}
