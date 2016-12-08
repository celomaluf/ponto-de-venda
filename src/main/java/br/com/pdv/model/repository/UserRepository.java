package br.com.pdv.model.repository;

import br.com.pdv.framework.data.BaseJPARepository;
import br.com.pdv.model.entity.User;

/**
 * @author Marcelo Maluf Teixeira
 *
 */
public interface UserRepository extends BaseJPARepository<User, Long> {

    User findByDeLogin(String deLogin);
    boolean signIn(User user);
}
