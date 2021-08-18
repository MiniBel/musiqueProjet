package fr.musique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.musique.model.Compte;

public interface ICompteDaoJpaRepository extends JpaRepository<Compte, Integer> {

}
