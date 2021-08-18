package fr.musique;

import java.time.LocalDate;

import fr.musique.dao.ICompteDao;
import fr.musique.dao.IUtilisateurDao;
import fr.musique.dao.jpa.CompteDaoJpa;
import fr.musique.dao.jpa.UtilisateurDaoJpa;
import fr.musique.model.Utilisateur;

public class ApplicationIngrid {

	public static void main(String[] args) {
		IUtilisateurDao daoUtilisateur = new UtilisateurDaoJpa();
		ICompteDao daoCompte = new CompteDaoJpa();
		
		ajoutUtilisateur(daoUtilisateur);;
	}

	public static void ajoutUtilisateur(IUtilisateurDao daoUtilisateur){
		
		
		Utilisateur u1 = new Utilisateur("Eyango", "Ingrid", LocalDate.of(1993, 03, 05));
		daoUtilisateur.save(u1);
	}
	
	public static void ajoutCompte(ICompteDao daoCompte) {
		
	}
	
	public static void associateCompteUtilisateur() {
		
	}
}
