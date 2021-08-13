package fr.musique;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.musique.dao.IAlbumDao;
import fr.musique.dao.IArtisteDao;
import fr.musique.dao.IChansonDao;
import fr.musique.dao.ICompteDao;
import fr.musique.dao.IGenreDao;
import fr.musique.dao.IUtilisateurDao;
import fr.musique.dao.jpa.AlbumDaoJpa;
import fr.musique.dao.jpa.ArtisteDaoJpa;
import fr.musique.dao.jpa.ChansonDaoJpa;
import fr.musique.dao.jpa.CompteDaoJpa;
import fr.musique.dao.jpa.GenreDaoJpa;
import fr.musique.dao.jpa.UtilisateurDaoJpa;
import fr.musique.model.Album;
import fr.musique.model.Artiste;
import fr.musique.model.Chanson;
import fr.musique.model.Compte;
import fr.musique.model.Genre;
import fr.musique.model.Utilisateur;

public class ApplicationBenoit {

	public static void main(String[] args) {
		IUtilisateurDao daoUtilisateur = new UtilisateurDaoJpa();
		ICompteDao daoCompte = new CompteDaoJpa();
		IArtisteDao daoArtiste = new ArtisteDaoJpa();
		IGenreDao daoGenre = new GenreDaoJpa();
		IChansonDao daoChanson = new ChansonDaoJpa();
		IAlbumDao daoAlbum = new AlbumDaoJpa();
		// ajoutUtilisateur(daoUtilisateur);
		// ajoutCompte(daoCompte);
		// associationCompteUtilisateur(daoUtilisateur, daoCompte);

		//ajoutGenre(daoGenre);
		//ajoutArtiste(daoArtiste, daoGenre);
		//ajoutAlbum(daoAlbum);
		ajoutChanson(daoChanson, daoAlbum);
		
	}

	public static void ajoutUtilisateur(IUtilisateurDao daoUtilisateur) {

		Utilisateur u1 = new Utilisateur("Chauvin", "Benoit", LocalDate.of(1996, 10, 31));
		daoUtilisateur.save(u1);
	}

	public static void ajoutCompte(ICompteDao daoCompte) {

		Compte c1 = new Compte("afqf@adqsd.com", "qqdqd32qd");
		daoCompte.save(c1);
	}

	public static void associationCompteUtilisateur(IUtilisateurDao daoUtilisateur, ICompteDao daoCompte) {
		Utilisateur util = daoUtilisateur.findById(1);
		Compte compte = daoCompte.findById(1);
		compte.setUtilisateur(util);
		daoCompte.update(compte);
	}
	public static void ajoutGenre(IGenreDao daoGenre){
		Genre genre = new Genre("Metal");
		daoGenre.save(genre);
	}
	public static void ajoutArtiste(IArtisteDao daoArtiste, IGenreDao daoGenre){
		Artiste artiste = new Artiste("IRON MAIDEN");
		Genre genre = daoGenre.findByName("Metal");
		artiste.setGenres(new ArrayList<>());
		artiste.getGenres().add(genre);
		
		daoArtiste.save(artiste);
	}
	public static void ajoutChanson(IChansonDao daoChanson, IAlbumDao daoAlbum){
		Chanson chanson = new Chanson("If Eternity Should Fail", 508);
		Chanson chanson2 = new Chanson("Speed of Light", 301);
		Chanson chanson3 = new Chanson("The Great Unknown", 397);
		
		Album album = daoAlbum.findByName("The Book of Souls");
		
		chanson.setAlbums(new ArrayList<>());
		chanson.getAlbums().add(album);
		chanson2.setAlbums(new ArrayList<>());
		chanson2.getAlbums().add(album);
		chanson3.setAlbums(new ArrayList<>());
		chanson3.getAlbums().add(album);
		
		daoChanson.save(chanson);
		daoChanson.save(chanson2);
		daoChanson.save(chanson3);
		album.setChansons(new ArrayList<>());
		album.getChansons().add(chanson);
		album.getChansons().add(chanson2);
		album.getChansons().add(chanson3);
		daoAlbum.save(album);
	}
	public static void ajoutAlbum(IAlbumDao daoAlbum){
		Album album = new Album("The Book of Souls", LocalDate.of(2015, 9, 04));
		
		daoAlbum.save(album);
	}
	
	
	
	
}
