package fr.musique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.musique.dao.IPlaylistDaoJpaRepository;
import fr.musique.model.Playlist;

@Controller
public class PlaylistController {

	@Autowired
	private IPlaylistDaoJpaRepository daoPlaylist;

	@GetMapping("/royalty-mesPlaylists")
	public String mesPlaylists(Model model) {
		model.addAttribute("playlists", daoPlaylist.findAll());

		return "mesPlaylists";
	}

	@GetMapping("/royalty-modifier-playlist")
	public String modif(@RequestParam int id, Model model) {
		model.addAttribute("playlist", daoPlaylist.findById(id).get());

		return "playlistForm";
	}

	@PostMapping("/royalty-modifier-playlist")
	public String modif(Playlist playlist) {

		daoPlaylist.save(playlist);

		return "redirect:/royalty-mesPlaylists";
	}

	@GetMapping("/royalty-supprimer-playlist")
	public String delete(@RequestParam int id) {
		daoPlaylist.deleteById(id);

		return "redirect:/royalty-mesPlaylists";
	}

	@PostMapping("/royalty-mesPlaylists")
	public String ajoutPlaylist(Playlist playlist) {

		daoPlaylist.save(playlist);

		return "redirect:/royalty-mesPlaylists";
	}
}
