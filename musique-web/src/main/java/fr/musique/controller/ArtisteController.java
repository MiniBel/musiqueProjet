package fr.musique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.musique.dao.IArtisteDaoJpaRepository;
import fr.musique.dao.IPlaylistDaoJpaRepository;
import fr.musique.model.Playlist;

@Controller
public class ArtisteController {
	@Autowired
	private IArtisteDaoJpaRepository daoArtiste;
	@Autowired
	private IPlaylistDaoJpaRepository daoPlaylist;

	@GetMapping("/royalty-artistes-util")
	public String listArtiste(Model model) {
		model.addAttribute("artistes", daoArtiste.findAll());
		model.addAttribute("playlists", daoPlaylist.findAll());
		return "artisteListe";
	}
	
	@PostMapping("/royalty-artistes-util")
	public String ajoutPlaylist(Playlist playlist) {

		daoPlaylist.save(playlist);

		return "redirect:/royalty-artistes-util";
	}

}
