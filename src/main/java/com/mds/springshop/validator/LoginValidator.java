package com.mds.springshop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mds.springshop.entity.Users;

public class LoginValidator implements Validator{
	public boolean supports(Class clazz) {
        return Users.class.isAssignableFrom(clazz);
    }
	public void validate(Object target, Errors errors) 
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.firstName", "First name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastName", "Last name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email", "Email is required.");
    }
	
}
