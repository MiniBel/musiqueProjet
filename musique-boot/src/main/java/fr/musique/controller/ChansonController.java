package fr.musique.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.musique.annotation.IsAdmin;
import fr.musique.dao.IAlbumDaoJpaRepository;
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

	@Autowired
	private IAlbumDaoJpaRepository daoAlbum;
	

	@GetMapping ("/royalty-chansons")
	public String findAll(Model model){
		model.addAttribute("playlists", daoPlaylist.findAll());
		model.addAttribute("chansons", daoChanson.findAll());
		return "chansonListe";
		
	}
	
	
	@Transactional
	@PostMapping("/royalty-chansons")
	public String addChansonPlaylist(@RequestParam int playlistId, @RequestParam int chansonId){
		Chanson chansonAAdd = daoChanson.findById(chansonId).get();
		Playlist playlist = daoPlaylist.findById(playlistId).get();
		service.addChansonToPlayList(chansonAAdd, playlist);
		return "redirect:/royalty-chansons";
	}

	@GetMapping ("/royalty-ajouter-chanson")
	@IsAdmin
	public String ajouter(Model model) {
		model.addAttribute("chansons", daoChanson.findAll());
		
		return "administrateurChansonForm";
	}
	
	@GetMapping ("/royalty-modifier-chanson")
	@IsAdmin
	public String edit(@RequestParam int id, Model model) {
		Chanson machansonAModifier = daoChanson.findById(id).get();
		
		model.addAttribute("chanson", machansonAModifier);
		model.addAttribute("albums", daoAlbum.findAll());
		
		return "administrateurChansonForm";
	}
	
	@PostMapping ({"/royalty-modifier-chanson", "/royalty-ajouter-chanson"})
	public String save (Chanson chanson) {
		daoChanson.save(chanson);
		
		return "redirect:/royalty-chansons";
	}
	
	@GetMapping("/royalty-supprimer-chanson")
	@IsAdmin
	public String deleteById(@RequestParam int id) {
		daoChanson.deleteById(id);

		return "redirect:/royalty-chansons";
	}
	
}
