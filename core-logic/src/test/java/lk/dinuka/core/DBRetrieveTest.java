package lk.dinuka.core;

import lk.dinuka.core.domain.DomainBook;
import lk.dinuka.core.domain.DomainUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by dinuka on 7/21/17.
 */
public class DBRetrieveTest {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
    private UserRepository userRepo = (UserRepository) applicationContext.getBean("userRepositoryImpl");
    private BookRepository bookRepo = (BookRepository) applicationContext.getBean("bookRepositoryImpl");


    @Before
    public void beforeTests(){
        userRepo.deleteAllUsers();

        userRepo.saveUser(new DomainUser(5, "Dinuka", "dinuka@gmail.com", "student"));
        userRepo.saveUser(new DomainUser(6, "Kamal", "kamal@gmail.com", "student"));
        userRepo.saveUser(new DomainUser(7, "Amal", "amal@gmail.com", "staff"));

        bookRepo.deleteAllBooks();

        bookRepo.saveBook(new DomainBook(9,"Book1", "Science", "Arther"));
        bookRepo.saveBook(new DomainBook(10,"Book2", "Science", "Conan"));
        bookRepo.saveBook(new DomainBook(11,"Book3", "Science", "Doyle"));

    }

    @Test
    public void getAllUsersTest(){
        List<DomainUser> userList = userRepo.getAllUsers();
        assertEquals(userList.size(), 3);
    }

    @Test
    public void getAllBooksTest(){
        List<DomainBook> bookList = bookRepo.getAllBooks();
        assertEquals(bookList.size(), 3);
    }

    @After
    public void afterAllTests(){
        userRepo.deleteAllUsers();
        bookRepo.deleteAllBooks();
    }

}
