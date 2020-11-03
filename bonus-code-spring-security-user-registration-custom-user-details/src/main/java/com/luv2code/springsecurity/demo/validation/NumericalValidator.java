package com.luv2code.springsecurity.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mysql.cj.util.StringUtils;


public class NumericalValidator implements ConstraintValidator<IsNumber, String> {
	@Override
	public boolean isValid(final String value,final ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(value == null) {
			return true;
		}
		if(value.length() < 5)
		{
			return false;
		}
		return StringUtils.isStrictlyNumeric(value);
	}

}
