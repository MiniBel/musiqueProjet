package fr.musique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.musique.dao.IPlaylistDaoJpaRepository;

@Controller
public class PlaylistController {

	@Autowired
	private IPlaylistDaoJpaRepository daoPlaylist;
	
	
	
}
