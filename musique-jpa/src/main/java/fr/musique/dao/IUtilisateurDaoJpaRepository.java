package fr.musique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.musique.model.Utilisateur;

public interface IUtilisateurDaoJpaRepository extends JpaRepository<Utilisateur, Integer> {

}
