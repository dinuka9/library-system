package lk.dinuka.core;

import lk.dinuka.core.domain.DomainUser;

import java.util.List;

/**
 * Created by dinuka on 7/19/17.
 */
public interface UserRepository {
    void saveUser(DomainUser domainUser);

    List<DomainUser> getAllUsers();

    DomainUser getUserById(int userId);

    void deleteUserById(int userId);

    void deleteAllUsers();
}
