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
import fr.musique.model.Chanson;

@Controller
public class AdministrateurChansonController {
	@Autowired
	private IChansonDaoJpaRepository daoChanson;
	
	@Autowired
	private IAlbumDaoJpaRepository daoAlbum;
	

	@GetMapping ("/royalty-chansons")
	public String findAll(Model model){
		model.addAttribute("chansons", daoChanson.findAll());
		return "administrateurChansonListe";
		
	}
	
	@GetMapping ("/royalty-ajouter-chanson")
	public String ajouter(Model model) {
		model.addAttribute("chansons", daoChanson.findAll());
		
		return "administrateurChansonForm";
	}
	
	@GetMapping ("/royalty-modifier-chanson")
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
	public String deleteById(@RequestParam int id) {
		daoChanson.deleteById(id);

		return "redirect:/royalty-chansons";
	}
	
	
}
