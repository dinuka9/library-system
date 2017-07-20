package lk.dinuka.core.service;

import lk.dinuka.core.domain.DomainBook;
import lk.dinuka.core.model.FormBook;

import java.util.List;

/**
 * Created by dinuka on 7/17/17.
 */
public interface BookService {

    void addBook(FormBook formBook);

    List<DomainBook> getBookList();

}
