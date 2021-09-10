package fr.musique.controller;

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
import fr.musique.dao.IArtisteDaoJpaRepository;
import fr.musique.dao.ICompteDaoJpaRepository;
import fr.musique.dao.IPlaylistDaoJpaRepository;
import fr.musique.model.Artiste;

@Controller
public class ArtisteController {
	@Autowired
	private IArtisteDaoJpaRepository daoArtiste;
	@Autowired
	private IPlaylistDaoJpaRepository daoPlaylist;
	@Autowired
	private ICompteDaoJpaRepository daoCompte;

	@GetMapping("/royalty-artistes")
	public String listArtiste(Model model, Authentication auth) {
		model.addAttribute("artistes", daoArtiste.findAll());
		model.addAttribute("playlists", this.daoCompte.findByEmail(auth.getName()).getPlaylists());
		return "artisteListe";
	}
	
	@GetMapping("/royalty-ajouter-artiste")
	@IsAdmin
	public String addArtiste(Model model, Authentication auth) {
		model.addAttribute("playlists", this.daoCompte.findByEmail(auth.getName()).getPlaylists());
		return "artisteForm";
	}

	@PostMapping("/royalty-ajouter-artiste")
	public String addArtiste(Artiste artiste) {
		daoArtiste.save(artiste);
		return "redirect:/royalty-artistes";
	}

	@GetMapping("/royalty-supprimer-artiste")
	@IsAdmin
	public String deleteArtiste(@RequestParam int id) {
		daoArtiste.deleteById(id);
		return "redirect:/royalty-artistes";
	}

	@GetMapping("/royalty-modifier-artiste")
	@IsAdmin
	public String modifArtiste(@RequestParam int id, Model model, Authentication auth) {
		model.addAttribute("artiste", daoArtiste.findById(id).get());
		model.addAttribute("playlists", this.daoCompte.findByEmail(auth.getName()).getPlaylists());;
		return "artisteForm";
	}

	@PostMapping("/royalty-modifier-artiste")
	public String modifArtiste(Artiste artiste) {
		daoArtiste.save(artiste);
		return "redirect:/royalty-artistes";
	}
	
	@GetMapping("/voirAlbums")
	@Transactional
	public String voirAlbum(@RequestParam int id, Model model, Authentication auth){
		Hibernate.initialize(daoArtiste.findById(id).get().getAlbums());
		model.addAttribute("albums", daoArtiste.findById(id).get().getAlbums());
		model.addAttribute("playlists", this.daoCompte.findByEmail(auth.getName()).getPlaylists());
		return "albumListe";
	}

}
