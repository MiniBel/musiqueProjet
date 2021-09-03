package fr.musique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.musique.dao.IPlaylistDaoJpaRepository;
import fr.musique.model.Playlist;

@Controller
public class AccueilConnecteController {

	@Autowired
	private IPlaylistDaoJpaRepository daoPlaylist;

	@GetMapping("/accueil-connecte")
	public String affichage(Model model) {
		model.addAttribute("playlists", daoPlaylist.findAll());

		return "accueilConnecte";
	}

	@PostMapping("/accueil-connecte")
	public String ajoutPlaylist(Playlist playlist) {

		daoPlaylist.save(playlist);

		return "redirect:/accueil-connecte";
	}

	@GetMapping("/accueil-connecte-administrateur")
	public String affichageAdmin() {
		return "accueilConnecteAdministrateur";
	}
}
