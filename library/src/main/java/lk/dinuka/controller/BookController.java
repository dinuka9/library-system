package lk.dinuka.controller;

import lk.dinuka.model.FormBook;
import lk.dinuka.model.FormUser;
import lk.dinuka.service.BookService;
import lk.dinuka.util.BookFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/**
 * Created by dinuka on 7/17/17.
 */
@Controller
@SessionAttributes(value = {"user", "book"})
public class BookController {

    private static int nextBookId = 1;
    @Autowired
    private BookService bookService;
    private List<String> bookTypeList;
    private BookFormValidator bookFormValidator;

//    @RequestMapping(value = "/addnewbook", method = RequestMethod.GET)
//    public String addNewBook(ModelMap modelMap) {
//        FormBook formBook = new FormBook();
//
//        formBook.setBookTypeList(bookTypeList);
//        formBook.setBookId(nextBookId.get());
//
//        modelMap.addAttribute("book", formBook);
//
//        return "register_book";
//    }

    @RequestMapping(value = "/registerbook", method = RequestMethod.POST)
    public String registerBook(@ModelAttribute("book") FormBook formBook, BindingResult bindingResult,
                               ModelMap modelMap) {

        bookFormValidator.validate(formBook, bindingResult);
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("user", new FormUser());
            modelMap.addAttribute("book", formBook);
            modelMap.addAttribute("bookFormError", "true");
            return "home";
        } else {
            bookService.addBook(formBook);
            nextBookId++;
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/viewbooks", method = RequestMethod.GET)
    public String viewAllBooks(ModelMap modelMap) {
        modelMap.addAttribute("bookList", bookService.getBookList());
        return "view_books";
    }

    public List<String> getBookTypeList() {
        return bookTypeList;
    }

    public void setBookTypeList(List<String> bookTypeList) {
        this.bookTypeList = bookTypeList;
    }

    public BookFormValidator getBookFormValidator() {
        return bookFormValidator;
    }

    public void setBookFormValidator(BookFormValidator bookFormValidator) {
        this.bookFormValidator = bookFormValidator;
    }

    public int getNextBookId() {
        return nextBookId;
    }

    public void setNextBookId(int nextBookId) {
        this.nextBookId = nextBookId;
    }

}
