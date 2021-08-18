package fr.musique.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.musique.service.UtilisateurService;

public class ApplicationBenoitJpaRepo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		UtilisateurService srvUtilisateur = myContext.getBean(UtilisateurService.class);
		
		srvUtilisateur.findByNom("Chauvin");

	}

}
