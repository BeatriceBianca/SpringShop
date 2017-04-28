package com.mds.springshop.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.apache.commons.validator.routines.EmailValidator;
import com.mds.springshop.dao.UsersDAO;
import com.mds.springshop.entity.Users;
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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstName","NotEmpty.registrationForm.firstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastName", "NotEmpty.registrationForm.lastName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","NotEmpty.registrationForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","NotEmpty.registrationForm.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"address","NotEmpty.registrationForm.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.registrationForm.phone");
        if (!emailValidator.isValid(userInfo.getEmail())){
			errors.rejectValue("email","Pattern.customerForm.email");
		}
        String email=userInfo.getEmail();
        if(email!=null&&userInfo.isNewUser())
        {
	        Users user=userDAO.findUserByEmail(email);
	        if(user!=null)
	        {
	        	errors.rejectValue("email","Duplicate.registrationForm.email");
	        }
        }
        if(String.valueOf(userInfo.getPhone()).length()!=9)
        	errors.rejectValue("phone","Size.registrationForm.phone");
	}
}
