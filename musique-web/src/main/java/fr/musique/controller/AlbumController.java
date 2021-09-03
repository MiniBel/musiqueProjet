package fr.musique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.musique.dao.IAlbumDaoJpaRepository;
import fr.musique.dao.IPlaylistDaoJpaRepository;
import fr.musique.model.Playlist;

@Controller
public class AlbumController {

	@Autowired
	private IPlaylistDaoJpaRepository daoPlaylist;

	@Autowired
	private IAlbumDaoJpaRepository daoAlbum;

	@GetMapping("/royalty-albums-util")
	public String listeAlbum(Model model) {
		model.addAttribute("playlists", daoPlaylist.findAll());
		model.addAttribute("albums", daoAlbum.findAll());

		return "albumListe";
	}
	
	@PostMapping("/royalty-albums-util")
	public String ajoutPlaylist(Playlist playlist) {

		daoPlaylist.save(playlist);

		return "redirect:/royalty-albums-util";
	}

}
