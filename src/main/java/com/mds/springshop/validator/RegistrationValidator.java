package com.mds.springshop.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.apache.commons.validator.routines.EmailValidator;
import com.mds.springshop.dao.UsersDAO;
import com.mds.springshop.model.UsersInfo;

@Component
public class RegistrationValidator implements Validator{
	
	private EmailValidator emailValidator = EmailValidator.getInstance();
	@Autowired
	private UsersDAO userDAO;
	@Override
	public boolean supports(Class<?> clazz)
	{
		return clazz==UsersInfo.class;
	}
	@Override
	public void validate(Object target,Errors errors)
	{
		UsersInfo userInfo=(UsersInfo) target;
		//Check fields
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"first_name","NotEmpty.registrationForm.firstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"last_name", "NotEmpty.registrationForm.lastName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","NotEmpty.registrationForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","NotEmpty.registrationForm.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"address","NotEmpty.registrationForm.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.registrationForm.phone");
        if (!emailValidator.isValid(userInfo.getEmail())){
			errors.rejectValue("email","Pattern.customerForm.email");;
		}
	}
}
