package com.mvc.learning.utils.validators;

import com.mvc.learning.dto.UserDetailDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Objects;


public class UserDetailsValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserDetailDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.empty","Last name cannot be empty");

        String email = ((UserDetailDTO) object).getCommunication().getEmail();

        if(!email.isEmpty()){
            String[] parts = email.split("@");
            if(!Objects.equals(parts[1], "selenium.com")){
                errors.rejectValue("communication.email", "invalid.email");
            }
        }

    }
}
