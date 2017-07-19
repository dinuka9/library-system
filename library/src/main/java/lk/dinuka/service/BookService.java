package lk.dinuka.service;

import lk.dinuka.model.DomainBook;
import lk.dinuka.model.FormBook;

import java.util.List;

/**
 * Created by dinuka on 7/17/17.
 */
public interface BookService {

    void addBook(FormBook formBook);

    List<DomainBook> getBookList();

}
