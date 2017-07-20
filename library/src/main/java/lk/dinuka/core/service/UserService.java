package lk.dinuka.core.service;

import lk.dinuka.core.domain.DomainUser;
import lk.dinuka.core.model.FormUser;

import java.util.List;

/**
 * Created by dinuka on 7/17/17.
 */
public interface UserService {

    void registerUser(FormUser user);

    List<DomainUser> getFormUserList();

}
