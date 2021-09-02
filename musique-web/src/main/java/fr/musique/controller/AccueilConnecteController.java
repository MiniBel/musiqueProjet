package fr.musique.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilConnecteController {

	@GetMapping("/accueil-connecte")
	public String affichage(){
		return "accueilConnecte";
	}
}
