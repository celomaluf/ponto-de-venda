package br.com.pdv.model.repository.impl;

import org.springframework.stereotype.Repository;

import br.com.pdv.framework.data.BaseHibernateJPARepository;
import br.com.pdv.model.entity.User;
import br.com.pdv.model.repository.UserRepository;

/**
 * @author Marcelo Maluf Teixeira
 *
 */
@Repository
public class UserRepositoryImpl extends BaseHibernateJPARepository<User, Long> implements UserRepository {
    
	
    @Override
    public User findByDeLogin(String deLogin) {
        return (User) sessionFactory.getCurrentSession().createQuery("FROM User u WHERE upper(u.deLogin) = upper(:deLogin)")
                .setParameter("deLogin", deLogin).uniqueResult();
    }

	@Override
	public boolean signIn(User user) {
	    return (sessionFactory.getCurrentSession().createQuery(" FROM User u WHERE 1=1 "
	    		+ " AND u.deLogin = :deLogin "
	    		+ " AND u.dePassword = :dePassword ")
                .setParameter("deLogin", user.getDeLogin())
                .setParameter("dePassword", user.getDePassword())
                .uniqueResult()) != null;
	}
}