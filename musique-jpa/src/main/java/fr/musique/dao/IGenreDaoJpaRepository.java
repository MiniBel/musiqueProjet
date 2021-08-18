package fr.musique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.musique.model.Genre;


public interface IGenreDaoJpaRepository extends JpaRepository <Genre, Integer>{

}
