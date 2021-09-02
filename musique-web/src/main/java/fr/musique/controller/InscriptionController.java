package fr.musique.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.musique.dao.ICompteDaoJpaRepository;
import fr.musique.dao.IUtilisateurDaoJpaRepository;
import fr.musique.model.Compte;
import fr.musique.model.Utilisateur;

@Controller
public class InscriptionController {

	@Autowired
	private ICompteDaoJpaRepository daoCompte;

	@Autowired
	private IUtilisateurDaoJpaRepository daoUtilisateur;

	@GetMapping("/royalty-inscription")
	public String inscription() {

		return "inscription";
	}

	@PostMapping("/royalty-inscription")
	public String inscription(@RequestParam String email, @RequestParam String password,
			@RequestParam String passwordConfirm, @RequestParam String nom, @RequestParam String prenom,
			@RequestParam int jour, @RequestParam int mois, @RequestParam int annee, Model model) {

		if (daoCompte.findByEmail(email) == null) {
			if (password.equals(passwordConfirm)) {
				Compte compte = new Compte(email, password);

				Utilisateur utilisateur = new Utilisateur(nom, prenom, LocalDate.of(annee, mois, jour));
				daoUtilisateur.save(utilisateur);

				compte.setUtilisateur(utilisateur);
				daoCompte.save(compte);

				return "redirect:/accueil-connecte";
			} else {
				model.addAttribute("erreur2", "mot de passe erroné");
				return "inscription";
			}

		} else {
			model.addAttribute("erreur", "email déjà utilisé");
			return "inscription";
		}

	}

}
