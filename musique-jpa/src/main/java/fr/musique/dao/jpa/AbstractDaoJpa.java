package fr.musique.dao.jpa;

import java.lang.reflect.Method;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractDaoJpa<T> {

	// CREATION DE L'EntityManagerFactory
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MusiqueUnit");

	// CREATION DE L'EntityManager
	protected EntityManager em = emf.createEntityManager();

	// Permet de fermer l'EMF et les EM associés (ceux créés à l'EMF)
	public static void close() {
		emf.close();
	}
	public T insert(T entity) {
		// Gémarrrage de la transaction
		em.getTransaction().begin();

		// Persistance du produit
		em.persist(entity);

		// Commit de la transaction
		em.getTransaction().commit();

		return entity;
	}

	public T update(T entity) {
		em.getTransaction().begin();
		entity = em.merge(entity);
		em.getTransaction().commit();
		return entity;
	}

	public void delete(T entity) {
		em.getTransaction().begin();

		// On attache l'entité à l'EtntityManager, avant de supprimer,
		// au cas où l'entité n'est pas déjà managée
		em.remove(em.merge(entity));

		em.getTransaction().commit();
	}

	// Pour remonter save ici : il faut utiliser reflexivite en java
	public T save(T entity) {
		int entityId = 0;
		try {
			Method method = entity.getClass().getMethod("getId");
			Object result = method.invoke(entity);
			entityId = (Integer) result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (entityId > 0) {
			// Update
			return this.update(entity);
		} else {
			// Insert
			return this.insert(entity);
		}
	}
	
	public void deleteById(Integer id) {
		this.delete(this.findById(id));
	}

	public abstract T findById(Integer id);
	
	
	
}
