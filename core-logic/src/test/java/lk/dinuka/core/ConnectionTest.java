package lk.dinuka.core;

import lk.dinuka.core.domain.DomainUser;
import lk.dinuka.core.util.DbAccess;

import java.util.List;

/**
 * Created by dinuka on 7/20/17.
 */
public class ConnectionTest {
    public static void main(String[] args) {

//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
//        UserRepository userRepo = (UserRepository) applicationContext.getBean("userRepositoryImpl");

        List<DomainUser> userList = DbAccess.getDBAccessInstance().getUserRepository().getAllUsers();
        for (DomainUser d : userList) {
            System.out.println(d.getUserId()+" "+d.getUserName()+" "+d.getMemberType()+" "+d.getUserEmail());
        }

//        DomainUser user = new DomainUser(3, "Amal", "amal@gmail.com", "student");
//        userRepo.saveUser(user);
//        DomainUser d = userRepo.getUserById(2);
//        System.out.println("\n"+d.getUserId()+" "+d.getUserName()+" "+d.getMemberType()+" "+d.getUserEmail());

    }

}
