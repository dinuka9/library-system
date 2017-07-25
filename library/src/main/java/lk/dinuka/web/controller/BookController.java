package lk.dinuka.web.controller;

import lk.dinuka.web.model.FormBook;
import lk.dinuka.web.model.FormUser;
import lk.dinuka.web.service.BookService;
import lk.dinuka.web.service.serviceImpl.BookServiceImpl;
import lk.dinuka.web.util.BookFormValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger LOGGER = LogManager.getLogger(BookController.class.getName());
    private static int nextBookId = 1;
    private List<String> bookTypeList;
    private BookFormValidator bookFormValidator;
    private BookService bookService;

    @RequestMapping(value = "/registerbook", method = RequestMethod.POST)
    public String registerBook(@ModelAttribute("book") FormBook formBook, BindingResult bindingResult,
                               ModelMap modelMap) {

        bookFormValidator.validate(formBook, bindingResult);
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("user", new FormUser());
            modelMap.addAttribute("book", formBook);
            modelMap.addAttribute("bookFormError", "true");

            LOGGER.warn("registerBook :: book validation failed");

            return "home";
        } else {
            LOGGER.info("registerBook :: book validation success");

            bookService.addBook(formBook);
            nextBookId++;
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/viewbooks", method = RequestMethod.GET)
    public String viewAllBooks(ModelMap modelMap) {
        modelMap.addAttribute("bookList", bookService.getBookList());

        LOGGER.info("viewAllBooks :: all books loaded");

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


    public void setBookService(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

}
