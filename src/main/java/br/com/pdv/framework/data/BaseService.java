package br.com.pdv.framework.data;

import java.io.Serializable;

/**
 * @author Marcelo Maluf Teixeira
 * 
 * Interface listing the most basic services required to be present in any
 * service built upon an domain entity object that is persisted using repository.
 */
public interface BaseService<T extends Entity, ID extends Serializable> {
    /**
     * Method to setup the service with basic
     * required data. Called after Spring initialization.
     */
    public void setupService();

    /**
     * Service to insert an entity
     *
     * @param entity
     *         The newly entity
     */
    public T insert(T entity) throws Exception;

    /**
     * Service to update an existing entity
     *
     * @param entity
     *         The existing entity
     */
    public T update(T entity) throws Exception;

    /**
     * Service to delete an existing entity
     *
     * @param entity
     *         The existing entity
     */
    public void delete(T entity) throws Exception;

    /**
     * Service to find an existing entity by its given id
     *
     * @param id
     *         Id of the resource
     */
    public T findById(ID id) throws Exception;
    
    
}
