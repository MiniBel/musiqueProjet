package fr.musique.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.musique.model.Genre;

public interface IGenreDaoJpaRepository extends JpaRepository<Genre, Integer> {

	@Query("select g from Genre g where g.nom = ?1")
	public Genre findByNom(String nom);

}
