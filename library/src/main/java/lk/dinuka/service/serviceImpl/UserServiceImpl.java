package lk.dinuka.service.serviceImpl;

import lk.dinuka.model.DomainUser;
import lk.dinuka.model.FormUser;
import lk.dinuka.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinuka on 7/17/17.
 */
public class UserServiceImpl implements UserService {

    private List<DomainUser> usersList = new ArrayList<DomainUser>();

    public void registerUser(FormUser user) {
        DomainUser newUser = new DomainUser(user.getUserId(), user.getUserName(), user.getUserEmail(), user.getMemberType());
        usersList.add(newUser);
    }

    public List<DomainUser> getFormUserList() {
        return usersList;
    }
}
