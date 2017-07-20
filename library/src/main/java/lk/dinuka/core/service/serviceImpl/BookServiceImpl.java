package lk.dinuka.core.service.serviceImpl;

import lk.dinuka.core.domain.DomainBook;
import lk.dinuka.core.model.FormBook;
import lk.dinuka.core.service.BookService;
import lk.dinuka.core.util.DbAccess;

import java.util.List;

/**
 * Created by dinuka on 7/17/17.
 */
public class BookServiceImpl implements BookService {

    public void addBook(FormBook formBook) {
        DomainBook domainBook = new DomainBook(formBook.getBookId(),formBook.getBookName(),formBook.getBookType(),formBook.getBookAuthor());
        DbAccess.getDBAccessInstance().getBookRepository().saveBook(domainBook);
    }

    public List<DomainBook> getBookList() {
        return DbAccess.getDBAccessInstance().getBookRepository().getAllBooks();
    }
}
