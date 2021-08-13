package fr.musique.service;

import java.util.List;

import fr.musique.model.Chanson;

public class DurationService {

	public int calculDureeTotal(List<Chanson> chansons) {
		int dureeTotal = 0;
		for (Chanson cha : chansons) {
			dureeTotal += cha.getDuree();
		}

		return dureeTotal;
	}

}