package lk.dinuka.web.service.serviceImpl;

import lk.dinuka.core.UserRepository;
import lk.dinuka.core.domain.DomainUser;
import lk.dinuka.web.model.FormUser;
import lk.dinuka.web.service.UserService;

import java.util.List;

/**
 * Created by dinuka on 7/17/17.
 */
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public void registerUser(FormUser user) {
        DomainUser newUser = new DomainUser(user.getUserId(),
                                            user.getUserName(),
                                            user.getUserEmail(),
                                            user.getMemberType());
        userRepository.saveUser(newUser);
    }

    public List<DomainUser> getFormUserList() {
        return userRepository.getAllUsers();
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
