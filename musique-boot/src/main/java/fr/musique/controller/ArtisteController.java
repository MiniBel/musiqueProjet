package fr.musique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.musique.annotation.IsAdmin;
import fr.musique.dao.IArtisteDaoJpaRepository;
import fr.musique.dao.IPlaylistDaoJpaRepository;
import fr.musique.model.Artiste;

@Controller
public class ArtisteController {
	@Autowired
	private IArtisteDaoJpaRepository daoArtiste;
	@Autowired
	private IPlaylistDaoJpaRepository daoPlaylist;

	@GetMapping("/royalty-artistes")
	public String listArtiste(Model model) {
		model.addAttribute("artistes", daoArtiste.findAll());
		model.addAttribute("playlists", daoPlaylist.findAll());
		return "artisteListe";
	}
	
	@GetMapping("/royalty-ajouter-artiste")
	@IsAdmin
	public String addArtiste(Model model) {
		model.addAttribute("playlists", daoPlaylist.findAll());
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
	public String modifArtiste(@RequestParam int id, Model model) {
		model.addAttribute("artiste", daoArtiste.findById(id).get());
		model.addAttribute("playlists", daoPlaylist.findAll());
		return "artisteForm";
	}

	@PostMapping("/royalty-modifier-artiste")
	public String modifArtiste(Artiste artiste) {
		daoArtiste.save(artiste);
		return "redirect:/royalty-artistes";
	}

}
