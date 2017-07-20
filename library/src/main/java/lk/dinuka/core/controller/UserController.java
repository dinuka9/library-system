package lk.dinuka.core.controller;

import lk.dinuka.core.model.FormBook;
import lk.dinuka.core.model.FormUser;
import lk.dinuka.core.service.UserService;
import lk.dinuka.core.util.UserFormValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/**
 * Created by deuke on 7/16/17.
 */
@Controller
@SessionAttributes(value = {"user", "book"})
public class UserController {

    private static int nextUserId = 1;
    private UserService userService;
    private UserFormValidator userFormValidator;
    private List<String> memberTypeList;
    private List<String> bookTypeList;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage(ModelMap modelMap) {

        FormUser formUser = new FormUser();
        formUser.setUserId(nextUserId);
        formUser.setMemberTypelist(memberTypeList);

        FormBook formBook = new FormBook();
        formBook.setBookTypeList(bookTypeList);
        formBook.setBookId(new BookController().getNextBookId());

        modelMap.addAttribute("user", formUser);
        modelMap.addAttribute("book", formBook);

        return "home";
    }

//    @RequestMapping(value = "/addnewuser", method = RequestMethod.GET)
//    public String addNewUser(ModelMap modelMap) {
//
//        FormUser formUser = new FormUser();
//        formUser.setUserId(nextUserId.get());
//        formUser.setMemberTypelist(memberTypeList);
//
//        FormBook formBook = new FormBook();
//
//        modelMap.addAttribute("user", formUser);
//
//        return "redirect:/";
//    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") FormUser formUser, BindingResult bindingResult,
                               ModelMap modelMap) {

        userFormValidator.validate(formUser, bindingResult);
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("user", formUser);
            modelMap.addAttribute("userFormError", "true");
            return "home";
        } else {
            userService.registerUser(formUser);
            nextUserId++;
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/viewusers", method = RequestMethod.GET)
    public String viewUsers(ModelMap model) {

        model.addAttribute("userlist", userService.getFormUserList());

        return "view_users";
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setMemberTypeList(List<String> memberTypeList) {
        this.memberTypeList = memberTypeList;
    }

    public void setUserFormValidator(UserFormValidator userFormValidator) {
        this.userFormValidator = userFormValidator;
    }

    public List<String> getBookTypeList() {
        return bookTypeList;
    }

    public void setBookTypeList(List<String> bookTypeList) {
        this.bookTypeList = bookTypeList;
    }
}
