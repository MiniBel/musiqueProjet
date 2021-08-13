package fr.musique.dao;

import java.util.List;

public interface IDAO<T, Id, Nom> {

	public List<T> findAll();

	public T findById(Id id);
	
	public T findByName(Nom nom);

	public T insert(T entity);

	public T update(T entity);

	public T save(T entity);

	public void delete(T entity);

	public void deleteById(Id id);

}
