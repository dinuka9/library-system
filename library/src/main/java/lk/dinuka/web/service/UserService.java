package lk.dinuka.web.service;

import lk.dinuka.core.domain.DomainUser;
import lk.dinuka.web.model.FormUser;

import java.util.List;

/**
 * Created by dinuka on 7/17/17.
 */
public interface UserService {

    void registerUser(FormUser user);

    List<DomainUser> getFormUserList();

}
