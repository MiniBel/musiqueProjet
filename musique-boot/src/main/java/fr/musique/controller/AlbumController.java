package fr.musique.controller;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.musique.annotation.IsAdmin;
import fr.musique.dao.IAlbumDaoJpaRepository;
import fr.musique.dao.IArtisteDaoJpaRepository;
import fr.musique.dao.ICompteDaoJpaRepository;
import fr.musique.dao.IPlaylistDaoJpaRepository;
import fr.musique.model.Album;
import fr.musique.model.Artiste;
import fr.musique.service.ChansonService;

@Controller
public class AlbumController {

	@Autowired
	private IPlaylistDaoJpaRepository daoPlaylist;

	@Autowired
	private IAlbumDaoJpaRepository daoAlbum;

	@Autowired
	private IArtisteDaoJpaRepository daoArtiste;

	@Autowired
	private ICompteDaoJpaRepository daoCompte;

	@Autowired
	private ChansonService service;

	@GetMapping("/royalty-albums")
	public String listeAlbum(Model model, Authentication auth) {
		model.addAttribute("playlists", this.daoCompte.findByEmail(auth.getName()).getPlaylists());
		model.addAttribute("albums", daoAlbum.findAll());

		return "albumListe";
	}

	@GetMapping("/royalty-ajouter-album")
	@IsAdmin
	public String ajoutAlbum(Model model, Authentication auth) {
		
		model.addAttribute("playlists", this.daoCompte.findByEmail(auth.getName()).getPlaylists());

		return "albumForm";
	}

	@GetMapping("/royalty-modifier-album")
	@IsAdmin
	public String modifAlbum(Model model, @RequestParam int id, Authentication auth) {
		model.addAttribute("album", daoAlbum.findById(id).get());

		model.addAttribute("playlists", this.daoCompte.findByEmail(auth.getName()).getPlaylists());

		return "albumForm";
	}

	@PostMapping("/royalty-ajouter-album")
	public String ajoutAlbum(@RequestParam String nom, @RequestParam int jour, @RequestParam int mois, @RequestParam int annee) {
		Album album = new Album(nom, LocalDate.of(annee, mois, jour));
		
		daoAlbum.save(album);

		return "redirect:/royalty-albums";
	}
	
	@PostMapping("/royalty-modifier-album")
	public String modifAlbum(@RequestParam int id, @RequestParam String nom, @RequestParam int jour, @RequestParam int mois, @RequestParam int annee){
		Album albumAModifier = daoAlbum.findById(id).get();
		
		albumAModifier.setNom(nom);
		albumAModifier.setDateParution(LocalDate.of(annee, mois, jour));
		
		daoAlbum.save(albumAModifier);
		
		return "redirect:/royalty-albums";
	}

	@GetMapping("/royalty-supprimer-album")
	@IsAdmin
	public String delete(@RequestParam int id) {
		daoAlbum.deleteById(id);

		return "redirect:/royalty-albums";
	}

	@GetMapping("/royalty-detail-album")
	@IsAdmin
	public String addArtiste (@RequestParam int id, Model model, Authentication auth) {
		Album album = daoAlbum.findById(id).get();

		model.addAttribute("artistes", daoArtiste.findAll());
		model.addAttribute("album", album);
		model.addAttribute("playlists", this.daoCompte.findByEmail(auth.getName()).getPlaylists());
		return "albumDetail";
	}

	@PostMapping("/royalty-detail-album")
	public String addArtiste(@RequestParam int albumId, @RequestParam int artisteId) {

		Artiste artisteAAjouter = daoArtiste.findById(artisteId).get();
		Album album = daoAlbum.findById(albumId).get();
		service.addArtisteToALbum(album, artisteAAjouter);
		return "redirect:/royalty-detail-album?id=" + albumId;
	}

	@GetMapping("/voirArtistes")
	@Transactional
	public String voirArtiste(@RequestParam int id, Model model, Authentication auth){
		Hibernate.initialize(daoAlbum.findById(id).get().getArtistes());
		model.addAttribute("artistes", daoAlbum.findById(id).get().getArtistes());
		model.addAttribute("playlists", this.daoCompte.findByEmail(auth.getName()).getPlaylists());
		return "artisteListe";
	}
	@GetMapping("/voirChansons")
	@Transactional
	public String voirChanson(@RequestParam int id, Model model, Authentication auth){
		Hibernate.initialize(daoAlbum.findById(id).get().getChansons());
		model.addAttribute("chansons", daoAlbum.findById(id).get().getChansons());
		model.addAttribute("playlists", this.daoCompte.findByEmail(auth.getName()).getPlaylists());
		return "chansonListe";
	}
}
