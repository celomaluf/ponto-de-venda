package br.com.pdv.framework.data;


import java.io.Serializable;

/**
 * @author Marcelo Maluf Teixeira
 * 
 * Basic access to service, based on CRUD entity.
 */
public abstract class BaseJPAServiceImpl<T extends Entity, ID extends Serializable> implements BaseService<T, ID> {
    protected BaseJPARepository<T, ID> baseJpaRepository;
    protected Class<T> entityClass;

    public T insert(T entity) throws Exception {
        return baseJpaRepository.insert(entity);
    }

    public T update(T entity) throws Exception {
        return baseJpaRepository.update(entity);
    }

    public void delete(T entity) throws Exception {
        baseJpaRepository.delete(entity);
    }
    
    public T findAll(ID id) throws Exception {
        T result = baseJpaRepository.findById(id);
        if (result != null) {
        	return result;        	
        }
        throw new Exception("Not Found");
    }
    
    public T findById(ID id) throws Exception {
        T result = baseJpaRepository.findById(id);
        if (result != null) {
        	return result;
        }
        throw new Exception("Not Found");
    }
}
