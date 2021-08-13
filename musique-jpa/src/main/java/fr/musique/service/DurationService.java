package fr.musique.service;

import java.util.List;

import fr.musique.model.Chanson;

public class DurationService {

	public int calculDureeTotal(List<Chanson> chansons) {
		int dureeTotal = 0;
		if (chansons != null) {
			for (Chanson cha : chansons) {
				dureeTotal += cha.getDuree();
			}
		} else {
			dureeTotal = 0;
		}
		return dureeTotal;
	}

}