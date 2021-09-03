package fr.musique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.musique.dao.IAlbumDaoJpaRepository;
import fr.musique.dao.IArtisteDaoJpaRepository;
import fr.musique.dao.IChansonDaoJpaRepository;
import fr.musique.dao.IPlaylistDaoJpaRepository;
import fr.musique.model.Chanson;

@Controller
public class ChansonController {
	@Autowired
	private IChansonDaoJpaRepository daoChanson;
	
	@Autowired
	private IPlaylistDaoJpaRepository daoPlaylist;
	

	@GetMapping ("/royalty-chansons-util")
	public String findAll(Model model){
		model.addAttribute("playlists", daoPlaylist.findAll());
		model.addAttribute("chansons", daoChanson.findAll());
		return "chansonListe";
		
	}
	
	
}
