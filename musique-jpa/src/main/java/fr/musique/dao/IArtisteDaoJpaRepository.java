package fr.musique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.musique.model.Artiste;

public interface IArtisteDaoJpaRepository extends JpaRepository<Artiste, Integer>{

}
