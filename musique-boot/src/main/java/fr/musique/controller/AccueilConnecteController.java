package fr.musique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.musique.dao.ICompteDaoJpaRepository;
import fr.musique.dao.IPlaylistDaoJpaRepository;
import fr.musique.model.Playlist;

@Controller
public class AccueilConnecteController {

	@Autowired
	private IPlaylistDaoJpaRepository daoPlaylist;

	@Autowired
	private ICompteDaoJpaRepository daoCompte;

	@GetMapping("/accueil-connecte")
	public String affichage(Model model, Authentication auth) {
		model.addAttribute("playlists", this.daoCompte.findByEmail(auth.getName()).getPlaylists());

		return "accueilConnecte";
	}

	@PostMapping("/accueil-connecte")
	public String ajoutPlaylist(Playlist playlist) {

		daoPlaylist.save(playlist);

		return "redirect:/accueil-connecte";
	}
}
