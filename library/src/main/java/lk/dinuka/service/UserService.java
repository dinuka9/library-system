package lk.dinuka.service;

import lk.dinuka.model.DomainUser;
import lk.dinuka.model.FormUser;

import java.util.List;

/**
 * Created by dinuka on 7/17/17.
 */
public interface UserService {

    void registerUser(FormUser user);

    List<DomainUser> getFormUserList();

}
