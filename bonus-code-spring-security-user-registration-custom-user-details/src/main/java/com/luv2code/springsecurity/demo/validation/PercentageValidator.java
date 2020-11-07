package com.luv2code.springsecurity.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PercentageValidator implements ConstraintValidator<IsNumber, String> {

	@Override
	public boolean isValid(final String value,final ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(value == null) {
			return true;
		}
		try {
			Double num = Double.parseDouble(value);
			if(num < 0 || num - 100 > 0)
			{
				return false;
			}
			return true;
		} catch(NumberFormatException e)
		{
			return false;
		}
	}

}
