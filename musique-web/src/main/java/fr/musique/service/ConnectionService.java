package fr.musique.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import fr.musique.model.Compte;

@Component
@SessionScope
public class ConnectionService {
	
	private Compte compte = new Compte();

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	

}
