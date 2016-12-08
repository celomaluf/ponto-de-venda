package br.com.pdv.service;

import br.com.pdv.framework.data.BaseService;
import br.com.pdv.model.entity.User;

/**
 * @author Marcelo Maluf Teixeira
 *
 */
public interface UserService extends BaseService<User, Long> {
	
	boolean signIn(User user);     
    User signUp(User user);
    boolean isDeLoginExists (String deLogin);
    
}
