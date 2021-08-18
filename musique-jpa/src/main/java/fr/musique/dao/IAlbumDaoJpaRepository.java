package fr.musique.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.musique.model.Album;

public interface IAlbumDaoJpaRepository extends JpaRepository<Album, Integer> {

	@Query("select a from Album a where a.nom = ?1")
	public Album findByNom(String nom);

}
