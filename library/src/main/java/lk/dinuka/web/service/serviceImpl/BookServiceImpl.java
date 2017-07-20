package lk.dinuka.web.service.serviceImpl;

import lk.dinuka.core.BookRepository;
import lk.dinuka.core.domain.DomainBook;
import lk.dinuka.web.model.FormBook;
import lk.dinuka.web.service.BookService;

import java.util.List;

/**
 * Created by dinuka on 7/17/17.
 */
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public void addBook(FormBook formBook) {
        DomainBook domainBook = new DomainBook( formBook.getBookId(), formBook.getBookName(),
                                                formBook.getBookType(),formBook.getBookAuthor());
        bookRepository.saveBook(domainBook);
    }

    public List<DomainBook> getBookList() {
        return bookRepository.getAllBooks();
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
