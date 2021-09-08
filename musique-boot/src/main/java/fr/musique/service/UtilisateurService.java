package fr.musique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.musique.dao.IUtilisateurDaoJpaRepository;
import fr.musique.model.Utilisateur;

@Service
public class UtilisateurService {

	@Autowired
	private IUtilisateurDaoJpaRepository daoUtilisateur;

	public void findByNom(String nom) {
		List<Utilisateur> mesUtilisateurs = daoUtilisateur.findByNom(nom);

		for (Utilisateur u : mesUtilisateurs) {
			System.out.println(u.getNom() + " " + u.getPrenom() + " " + u.getDateDeNaissance());
		}
	}
}
