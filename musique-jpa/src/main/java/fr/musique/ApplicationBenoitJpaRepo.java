package fr.musique;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.musique.config.AppConfig;
import fr.musique.dao.IAlbumDaoJpaRepository;
import fr.musique.dao.IArtisteDaoJpaRepository;
import fr.musique.dao.IChansonDaoJpaRepository;
import fr.musique.dao.ICompteDaoJpaRepository;
import fr.musique.dao.IGenreDaoJpaRepository;
import fr.musique.dao.IPlaylistDaoJpaRepository;
import fr.musique.dao.IUtilisateurDaoJpaRepository;
import fr.musique.model.Album;
import fr.musique.model.Artiste;
import fr.musique.model.Chanson;
import fr.musique.model.Compte;
import fr.musique.model.Genre;
import fr.musique.model.Playlist;
import fr.musique.model.Utilisateur;
import fr.musique.service.ChansonService;
import fr.musique.service.DurationService;

public class ApplicationBenoitJpaRepo {

	@Autowired
	private IUtilisateurDaoJpaRepository daoUtilisateur;

	@Autowired
	private ICompteDaoJpaRepository daoCompte;

	@Autowired
	private IGenreDaoJpaRepository daoGenre;

	@Autowired
	private IArtisteDaoJpaRepository daoArtiste;

	@Autowired
	private IAlbumDaoJpaRepository daoAlbum;

	@Autowired
	private IChansonDaoJpaRepository daoChanson;

	@Autowired
	private IPlaylistDaoJpaRepository daoPlaylist;

	@Autowired
	private ChansonService srvChanson;

	@Autowired
	private DurationService srvDuration;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);

		myContext.getBeanFactory().createBean(ApplicationBenoitJpaRepo.class).ajoutPlaylistAssociationChanson();

	}

	public void ajoutUtilisateur() {
		Utilisateur utilisateur = new Utilisateur("Dupond", "toto", LocalDate.of(1990, 12, 22));

		utilisateur = daoUtilisateur.save(utilisateur);
	}

	public void ajoutCompte() {
		Compte compte = new Compte("dupond.toto@gmail.com", "apfapfn");

		compte = daoCompte.save(compte);
	}

	public void associationCompteUtilisateur() {
		Compte compte = daoCompte.findByEmail("dupond.toto@gmail.com");
		Optional<Utilisateur> optUtilisateur = daoUtilisateur.findById(2);
		if (optUtilisateur.isPresent()) {
			System.out.println("J'ai un utilisateur");
			System.out.println(optUtilisateur.get().getNom());
		} else {
			System.out.println("Je n'ai pas d'utilisateur");
		}

		Utilisateur utilisateur = optUtilisateur.get();

		compte.setUtilisateur(utilisateur);
		daoCompte.save(compte);
	}

	public void ajoutArtisteEtGenre() {
		Artiste artiste = new Artiste("Orelsan");
		Genre genre = new Genre("RAP");

		genre = daoGenre.save(genre);

		artiste.setGenres(new ArrayList<>());
		artiste.getGenres().add(genre);

		artiste = daoArtiste.save(artiste);
	}

	@Transactional
	public void ajoutChansonAlbum() {

		Album album = new Album("La fête est finie", LocalDate.of(2017, 10, 20));

		album = daoAlbum.save(album);

		Chanson chanson = daoChanson.findByTitre("San");

		srvChanson.addChansonToAlbum(chanson, album);

		Chanson chanson2 = daoChanson.findByTitre("La fête est finie");

		srvChanson.addChansonToAlbum(chanson2, album);
	}

	public void ajoutPlaylistAssociationChanson() {
		Playlist playlist = new Playlist("PlaylistN3");
		playlist = daoPlaylist.save(playlist);
		Chanson chanson = daoChanson.findByTitre("San");

		srvChanson.addChansonToPlayList(chanson, playlist);

		Chanson chanson2 = daoChanson.findByTitre("If Eternity Should Fail");

		srvChanson.addChansonToPlayList(chanson2, playlist);
	}

}
