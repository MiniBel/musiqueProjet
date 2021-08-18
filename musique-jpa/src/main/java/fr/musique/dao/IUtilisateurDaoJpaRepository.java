package fr.musique.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.musique.model.Utilisateur;

public interface IUtilisateurDaoJpaRepository extends JpaRepository<Utilisateur, Integer> {

	@Query("select u from Utilisateur u where u.nom = ?1")
	public List<Utilisateur> findByNom(String nom);

}
