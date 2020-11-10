package com.luv2code.springsecurity.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class DecimalValidator implements ConstraintValidator<IsDecimal, Double> {

	@Override
	public boolean isValid(final Double value,final ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(value == null) {
			return true;
		}
		try {
			if(value < 0)
			{
				return false;
			}
			return true;
		} catch(Exception e)
		{
			return false;
		}
	}

}
