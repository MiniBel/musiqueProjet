package fr.musique.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.musique.model.Compte;

public interface ICompteDaoJpaRepository extends JpaRepository<Compte, Integer> {

	@Query("select c from Compte c where c.email = ?1")
	public Compte findByEmail(String email);

}
