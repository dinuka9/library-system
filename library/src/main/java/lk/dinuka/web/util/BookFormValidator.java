package lk.dinuka.web.util;

import lk.dinuka.web.model.FormBook;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by dinuka on 7/18/17.
 */
public class BookFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return FormBook.class.isAssignableFrom(aClass);    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookName", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookType", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookAuthor", "field.required");
    }
}
