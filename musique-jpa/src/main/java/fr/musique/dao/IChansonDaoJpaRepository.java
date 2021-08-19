package fr.musique.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.musique.model.Chanson;

public interface IChansonDaoJpaRepository extends JpaRepository<Chanson, Integer> {

	//@Query("select c from Chanson c where c.titre = ?1")
	@Query("select c from Chanson c left join fetch c.playlists where c.titre = ?1")
	public Chanson findByTitre(String titre);

}
