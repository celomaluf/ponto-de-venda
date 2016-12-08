package br.com.pdv.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pdv.framework.data.BaseJPAServiceImpl;
import br.com.pdv.model.entity.User;
import br.com.pdv.model.repository.UserRepository;
import br.com.pdv.service.UserService;

/**
 * @author Marcelo Maluf Teixeira
 *
 */
@Service
@Transactional
public class UserServiceImpl extends BaseJPAServiceImpl<User, Long> implements UserService {
	
	private @Autowired UserRepository userRepository;
    
    @PostConstruct
    public void setupService() {
        this.baseJpaRepository = userRepository;
        this.entityClass = User.class;
        this.baseJpaRepository.setupEntityClass(User.class);
    }

    @Override
    public User signUp(User user) {
        return userRepository.insert(user);
    }
   
    @Override
    public boolean isDeLoginExists(String deLogin) {
        if (userRepository.findByDeLogin(deLogin) != null) {
            return true;
        } 
        return false;
    }

	@Override
	public boolean signIn(User user) {
		if (userRepository.signIn(user)) {
			return true;
        } 
        return false;	
    }
}
