package lk.dinuka.service.serviceImpl;

import lk.dinuka.model.DomainBook;
import lk.dinuka.model.FormBook;
import lk.dinuka.service.BookService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinuka on 7/17/17.
 */
public class BookServiceImpl implements BookService {
    private List<DomainBook> booksList = new ArrayList<DomainBook>();

    public void addBook(FormBook formBook) {
        booksList.add(new DomainBook(formBook.getBookId(),formBook.getBookName(),formBook.getBookAuthor(),formBook.getBookType()));
    }

    public List<DomainBook> getBookList() {
        return booksList;
    }
}
