package br.com.pdv.model.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.pdv.framework.data.BaseHibernateJPARepository;
import br.com.pdv.model.entity.PDV;
import br.com.pdv.model.repository.PDVRepository;

/**
 * @author Marcelo Maluf Teixeira
 *
 */
@Repository
public class PDVRepositoryImpl extends BaseHibernateJPARepository<PDV, Long> implements PDVRepository {
    
	@SuppressWarnings("unchecked")
	@Override
	public List<PDV> findAll() {
		 return (List<PDV>) sessionFactory.getCurrentSession().createQuery("FROM PDV").list();
	}
}
