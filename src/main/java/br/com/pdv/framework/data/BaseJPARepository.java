package br.com.pdv.framework.data;

import java.io.Serializable;

/**
 * @author Marcelo Maluf Teixeira
 *
 */
public interface BaseJPARepository<T extends Entity, ID extends Serializable> {

	public void setupEntityClass(@SuppressWarnings("rawtypes") Class clazz);

	public T insert(T entity);

	public T update(T entity);
    
	public void delete(T entity);
    
	public T findById(ID id);
	
    
}
