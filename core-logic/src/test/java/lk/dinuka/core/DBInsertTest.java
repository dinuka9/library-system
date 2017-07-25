package lk.dinuka.core;

import lk.dinuka.core.domain.DomainBook;
import lk.dinuka.core.domain.DomainUser;
import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;


/**
 * Created by dinuka on 7/20/17.
 */
public class DBInsertTest {
    private ApplicationContext appContext = new ClassPathXmlApplicationContext("Beans.xml");
    private UserRepository userRepo = (UserRepository) appContext.getBean("userRepositoryImpl");
    private BookRepository bookRepo = (BookRepository) appContext.getBean("bookRepositoryImpl");


    @Test
    public void insertUserTest() {
        DomainUser user = new DomainUser(26, "Dinuka",
                "dinuka@hotmail.com", "student");

        userRepo.saveUser(user);

        DomainUser insertedUser = userRepo.getUserById(26);

        assertEquals(user.getUserName(), insertedUser.getUserName());
        assertEquals(user.getUserEmail(), insertedUser.getUserEmail());
        assertEquals(user.getMemberType(), insertedUser.getMemberType());

    }

    @Test
    public void insertBookTest() {
        DomainBook book = new DomainBook(12, "Book1", "Science", "Arther");

        bookRepo.saveBook(book);

        DomainBook insertedBook = bookRepo.getBookById(12);

        assertEquals(book.getBookName(), insertedBook.getBookName());
        assertEquals(book.getBookType(), insertedBook.getBookType());
        assertEquals(book.getBookAuthor(), insertedBook.getBookAuthor());

    }


    @After
    public void afterTestInsetUser() {
        userRepo.deleteUserById(26);
        bookRepo.deleteBookById(12);
    }

}
