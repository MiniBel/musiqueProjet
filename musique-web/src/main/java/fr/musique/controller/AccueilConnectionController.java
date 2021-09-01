package fr.musique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.musique.dao.ICompteDaoJpaRepository;
import fr.musique.model.Compte;
import fr.musique.service.ConnectionService;

@Controller
public class AccueilConnectionController {
	
	@Autowired
	private ConnectionService connexion;
	
	@Autowired
	private ICompteDaoJpaRepository daoCompte;
	
	@GetMapping("/accueil-connection")
	public String affichage(){
		return "accueilConnection";
	}

	@PostMapping("/accueil-connection")
	public String connection(@RequestParam String email,@RequestParam String password,Model model){
		Compte compteAConnecter = daoCompte.findByEmail(email);
		String c = "accueil-connection";
		if (compteAConnecter.getPassword() != password){
			c = "redirect:/accueil-connecte";
		}else{
			model.addAttribute("erreur", "Vous vous êtes trompé, béta !");
		}
		return c;
	}
}
