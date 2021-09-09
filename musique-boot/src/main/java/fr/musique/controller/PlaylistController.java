package fr.musique.controller;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
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
	
	@PostMapping("/royalty-ajouter-playlist")
	public String ajoutPlaylist(Playlist playlist) {

		daoPlaylist.save(playlist);

		return "redirect:/royalty-mesPlaylists";
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
	
	@GetMapping("/liste-chansons-playlist")
	@Transactional
	public String findAllChanson(@RequestParam int id, Model model){
		Playlist playlist = daoPlaylist.findById(id).get();
		
		Hibernate.initialize(playlist.getChansons());
		model.addAttribute("chansons", playlist.getChansons());

		model.addAttribute("playlists", daoPlaylist.findAll());
		
		return "chansonListePlaylist";
	}
}
