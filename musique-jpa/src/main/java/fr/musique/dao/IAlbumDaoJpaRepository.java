package fr.musique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.musique.model.Album;

public interface IAlbumDaoJpaRepository extends JpaRepository<Album, Integer>{

}
