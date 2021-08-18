package fr.musique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.musique.model.Playlist;

public interface IPlaylistDaoJpaRepository extends JpaRepository <Playlist, Integer>{

}
