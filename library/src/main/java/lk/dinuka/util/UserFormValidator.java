package lk.dinuka.util;

import lk.dinuka.model.FormUser;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by dinuka on 7/18/17.
 */
public class UserFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return FormUser.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        FormUser user = (FormUser) o;

        if (user.getUserEmail().equals("")){
            errors.rejectValue("userEmail", "field.required");
        }
        else if (!user.getUserEmail().contains("@")){
            errors.rejectValue("userEmail", "invalid.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberType", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "field.required");

    }
}
