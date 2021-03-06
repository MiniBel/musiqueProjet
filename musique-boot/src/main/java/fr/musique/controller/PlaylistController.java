package fr.musique.controller;

import java.security.Principal;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.musique.dao.IChansonDaoJpaRepository;
import fr.musique.dao.ICompteDaoJpaRepository;
import fr.musique.dao.IPlaylistDaoJpaRepository;
import fr.musique.model.Chanson;
import fr.musique.model.Compte;
import fr.musique.model.Playlist;
import fr.musique.security.ComptePrincipal;
import fr.musique.service.ChansonService;

@Controller
public class PlaylistController {

	@Autowired
	private IPlaylistDaoJpaRepository daoPlaylist;

	@Autowired
	private IChansonDaoJpaRepository daoChanson;

	@Autowired
	private ICompteDaoJpaRepository daoCompte;

	@Autowired
	private ChansonService service;

	@GetMapping("/royalty-mesPlaylists")
	public String mesPlaylists(Model model, Authentication auth) {

		model.addAttribute("playlists", this.daoCompte.findByEmail(auth.getName()).getPlaylists());

		return "mesPlaylists";
	}
	
	@PostMapping("/royalty-ajouter-playlist")
	public String ajoutPlaylist(Playlist playlist, Authentication auth) {
		// int compteId = ((ComptePrincipal)auth.getPrincipal()).getId();

		Compte compte = this.daoCompte.findByEmail(auth.getName());
		Playlist playlistAAssocier = daoPlaylist.save(playlist);
		
		if (compte.getPlaylists() == null) {
			compte.setPlaylists(new ArrayList<>());
		}
		compte.getPlaylists().add(playlistAAssocier);

		compte = daoCompte.save(compte);

		playlistAAssocier.setCompte(compte);

		playlistAAssocier = daoPlaylist.save(playlistAAssocier);

		

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
		model.addAttribute("playlist", playlist);
		model.addAttribute("playlists", daoPlaylist.findAll());
		
		return "chansonListePlaylist";
	}

	@PostMapping("/liste-chansons-playlist")
	@Transactional
	public String removeById(@RequestParam int playlistId, @RequestParam int chansonId){
		Chanson chansonAsupp = daoChanson.findById(chansonId).get();
		Playlist playlist = daoPlaylist.findById(playlistId).get();
		service.removeChansonToPlayList(chansonAsupp, playlist);
		return "redirect:/liste-chansons-playlist?id=" + playlistId;
	}

}
