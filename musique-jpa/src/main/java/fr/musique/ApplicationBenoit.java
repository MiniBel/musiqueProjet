package fr.musique;

import java.time.LocalDate;
import java.util.ArrayList;

import fr.musique.dao.IArtisteDao;
import fr.musique.dao.ICompteDao;
import fr.musique.dao.IGenreDao;
import fr.musique.dao.IUtilisateurDao;
import fr.musique.dao.jpa.ArtisteDaoJpa;
import fr.musique.dao.jpa.CompteDaoJpa;
import fr.musique.dao.jpa.GenreDaoJpa;
import fr.musique.dao.jpa.UtilisateurDaoJpa;
import fr.musique.model.Artiste;
import fr.musique.model.Compte;
import fr.musique.model.Genre;
import fr.musique.model.Utilisateur;

public class ApplicationBenoit {

	public static void main(String[] args) {
		IUtilisateurDao daoUtilisateur = new UtilisateurDaoJpa();
		ICompteDao daoCompte = new CompteDaoJpa();
		IArtisteDao daoArtiste = new ArtisteDaoJpa();
		IGenreDao daoGenre = new GenreDaoJpa();
		
		// ajoutUtilisateur(daoUtilisateur);
		// ajoutCompte(daoCompte);
		// associationCompteUtilisateur(daoUtilisateur, daoCompte);

		//ajoutGenre(daoGenre);
		ajoutArtiste(daoArtiste, daoGenre);
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
}
