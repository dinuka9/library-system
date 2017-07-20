package lk.dinuka.core;

import lk.dinuka.core.domain.DomainBook;

import java.util.List;

/**
 * Created by dinuka on 7/19/17.
 */
public interface BookRepository {
    void saveBook(DomainBook domainBook);

    List<DomainBook> getAllBooks();

    DomainBook getBookById(int bookId);

    void deleteBookById(int bookId);

    void deleteAllBooks();
}
