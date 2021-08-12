package fr.musique.dao.jpa;

import java.lang.reflect.Method;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractDaoJpa<T> {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MusiqueUnit");

	protected EntityManager em = emf.createEntityManager();

	public static void close() {
		emf.close();
	}

	public T insert(T entity) {

		em.getTransaction().begin();

		em.persist(entity);

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

		em.remove(em.merge(entity));

		em.getTransaction().commit();
	}

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

			return this.update(entity);
		} else {

			return this.insert(entity);
		}
	}

	public void deleteById(Integer id) {
		this.delete(this.findById(id));
	}

	public abstract T findById(Integer id);

}
