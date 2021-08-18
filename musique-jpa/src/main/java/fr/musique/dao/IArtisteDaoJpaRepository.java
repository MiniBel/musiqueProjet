package fr.musique.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.musique.model.Artiste;

public interface IArtisteDaoJpaRepository extends JpaRepository<Artiste, Integer> {

	@Query("select a from Artiste a where a.nom = ?1")
	public Artiste findByNom(String nom);

}
