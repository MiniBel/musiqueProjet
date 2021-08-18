package fr.musique.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.musique.model.Playlist;

public interface IPlaylistDaoJpaRepository extends JpaRepository<Playlist, Integer> {

	@Query("select p from Playlist p where p.nom = ?1")
	public Playlist findByNom(String nom);

}
