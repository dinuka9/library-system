package lk.dinuka.core.service.serviceImpl;

import lk.dinuka.core.domain.DomainUser;
import lk.dinuka.core.model.FormUser;
import lk.dinuka.core.service.UserService;
import lk.dinuka.core.util.DbAccess;

import java.util.List;

/**
 * Created by dinuka on 7/17/17.
 */
public class UserServiceImpl implements UserService {


    public void registerUser(FormUser user) {
        DomainUser newUser = new DomainUser(user.getUserId(), user.getUserName(), user.getUserEmail(), user.getMemberType());
        DbAccess.getDBAccessInstance().getUserRepository().saveUser(newUser);
    }

    public List<DomainUser> getFormUserList() {
        return DbAccess.getDBAccessInstance().getUserRepository().getAllUsers();
    }
}
