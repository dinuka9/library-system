package lk.dinuka.web.service;

import lk.dinuka.core.domain.DomainBook;
import lk.dinuka.web.model.FormBook;

import java.util.List;

/**
 * Created by dinuka on 7/17/17.
 */
public interface BookService {

    void addBook(FormBook formBook);

    List<DomainBook> getBookList();

}
