package fr.musique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.musique.model.Chanson;

public interface IChansonDaoJpaRepository extends JpaRepository<Chanson, Integer>{

}
