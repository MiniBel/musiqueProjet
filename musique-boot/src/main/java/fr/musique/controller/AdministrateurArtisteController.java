package fr.musique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.musique.dao.IArtisteDaoJpaRepository;
import fr.musique.model.Artiste;

@Controller
public class AdministrateurArtisteController {

	@Autowired
	private IArtisteDaoJpaRepository daoArtiste;

	@GetMapping("/royalty-artistes")
	public String listArtiste(Model model) {
		model.addAttribute("artistes", daoArtiste.findAll());
		return "administrateurArtisteListe";
	}

	@GetMapping("/royalty-ajouter-artiste")
	public String addArtiste() {
		return "administrateurArtisteForm";
	}

	@PostMapping("/royalty-ajouter-artiste")
	public String addArtiste(Artiste artiste) {
		daoArtiste.save(artiste);
		return "redirect:/royalty-artistes";
	}

	@GetMapping("/royalty-supprimer-artiste")
	public String deleteArtiste(@RequestParam int id) {
		daoArtiste.deleteById(id);
		return "redirect:/royalty-artistes";
	}

	@GetMapping("/royalty-modifier-artiste")
	public String modifArtiste(@RequestParam int id, Model model) {
		model.addAttribute("artiste", daoArtiste.findById(id).get());
		return "administrateurArtisteForm";
	}

	@PostMapping("/royalty-modifier-artiste")
	public String modifArtiste(Artiste artiste) {
		daoArtiste.save(artiste);
		return "redirect:/royalty-artistes";
	}

}
