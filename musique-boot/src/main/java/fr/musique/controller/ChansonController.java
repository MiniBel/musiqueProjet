package fr.musique.controller;

import javax.transaction.Transactional;

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
import fr.musique.model.Playlist;
import fr.musique.service.ChansonService;

@Controller
public class ChansonController {
	@Autowired
	private IChansonDaoJpaRepository daoChanson;
	
	@Autowired
	private IPlaylistDaoJpaRepository daoPlaylist;
	
	@Autowired
	private ChansonService service;
	

	@GetMapping ("/royalty-chansons-util")
	public String findAll(Model model){
		model.addAttribute("playlists", daoPlaylist.findAll());
		model.addAttribute("chansons", daoChanson.findAll());
		return "chansonListe";
		
	}
	
	
	@Transactional
	@PostMapping("/royalty-chansons-util")
	public String addChansonPlaylist(@RequestParam int playlistId, @RequestParam int chansonId){
		Chanson chansonAAdd = daoChanson.findById(chansonId).get();
		Playlist playlist = daoPlaylist.findById(playlistId).get();
		service.addChansonToPlayList(chansonAAdd, playlist);
		return "redirect:/royalty-chansons-util";
	}
	
}
