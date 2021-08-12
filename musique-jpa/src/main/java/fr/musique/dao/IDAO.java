package fr.musique.dao;

import java.util.List;

public interface IDAO<T, Id> {

	public List<T> findAll();

	public T findById();

	public T insert(T entity);

	public T update(T entity);

	public T save(T entity);

	public void delete(T entity);

	public void deleteById(Id id);

}
