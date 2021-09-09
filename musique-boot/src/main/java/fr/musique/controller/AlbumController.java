package fr.musique.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.musique.annotation.IsAdmin;
import fr.musique.dao.IAlbumDaoJpaRepository;
import fr.musique.dao.IArtisteDaoJpaRepository;
import fr.musique.dao.IPlaylistDaoJpaRepository;
import fr.musique.model.Album;

@Controller
public class AlbumController {

	@Autowired
	private IPlaylistDaoJpaRepository daoPlaylist;

	@Autowired
	private IAlbumDaoJpaRepository daoAlbum;

	@Autowired
	private IArtisteDaoJpaRepository daoArtiste;

	@GetMapping("/royalty-albums")
	public String listeAlbum(Model model) {
		model.addAttribute("playlists", daoPlaylist.findAll());
		model.addAttribute("albums", daoAlbum.findAll());

		return "albumListe";
	}

	@GetMapping("/royalty-ajouter-album")
	@IsAdmin
	public String ajoutAlbum(Model model) {
		
		model.addAttribute("playlists", daoPlaylist.findAll());

		return "albumForm";
	}

	@GetMapping("/royalty-modifier-album")
	@IsAdmin
	public String modifAlbum(Model model, @RequestParam int id) {
		model.addAttribute("album", daoAlbum.findById(id).get());

		model.addAttribute("playlists", daoPlaylist.findAll());

		return "albumForm";
	}

	@PostMapping("/royalty-ajouter-album")
	public String ajoutAlbum(@RequestParam String nom, @RequestParam int jour, @RequestParam int mois, @RequestParam int annee) {
		Album album = new Album(nom, LocalDate.of(annee, mois, jour));
		
		daoAlbum.save(album);

		return "redirect:/royalty-albums";
	}
	
	@PostMapping("/royalty-modifier-album")
	public String modifAlbum(@RequestParam int id, @RequestParam String nom, @RequestParam int jour, @RequestParam int mois, @RequestParam int annee){
		Album albumAModifier = daoAlbum.findById(id).get();
		
		albumAModifier.setNom(nom);
		albumAModifier.setDateParution(LocalDate.of(annee, mois, jour));
		
		daoAlbum.save(albumAModifier);
		
		return "redirect:/royalty-albums";
	}

	@GetMapping("/royalty-supprimer-album")
	@IsAdmin
	public String delete(@RequestParam int id) {
		daoAlbum.deleteById(id);

		return "redirect:/royalty-albums";
	}

}
