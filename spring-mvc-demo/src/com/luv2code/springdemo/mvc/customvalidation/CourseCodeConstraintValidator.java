package com.luv2code.springdemo.mvc.customvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements
 ConstraintValidator<Coursecode, String>{
	
	public String prefix;
	
	 @Override
	public void initialize(Coursecode constraintAnnotation) {
	
		 prefix = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String thecode, ConstraintValidatorContext theConstraintValidatorContext) {
		
		boolean result;
		
		if(thecode!=null)
		{
			result=thecode.startsWith(prefix);
		}
		else
		{
			result=true;
		}
		
		return result;
	}
	
	

}
