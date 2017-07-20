package lk.dinuka.core.util;

import lk.dinuka.core.BookRepository;
import lk.dinuka.core.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dinuka on 7/20/17.
 */
public class DbAccess {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
    private UserRepository userRepository = (UserRepository) applicationContext.getBean("userRepositoryImpl");
    private BookRepository bookRepository = (BookRepository) applicationContext.getBean("bookRepositoryImpl");
    private static DbAccess dbInstance = new DbAccess();

    public static DbAccess getDBAccessInstance(){
        return dbInstance;
    }
    private DbAccess(){

    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
