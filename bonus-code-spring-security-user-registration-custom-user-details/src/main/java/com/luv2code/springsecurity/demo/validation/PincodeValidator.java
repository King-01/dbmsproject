package com.luv2code.springsecurity.demo.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PincodeValidator implements ConstraintValidator<IsPincode, String> {

	private Pattern pattern;
	private Matcher matcher;
	private static final String Pincode_REGEX = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$";
	@Override
	public boolean isValid(final String value,final ConstraintValidatorContext context) {
		pattern = Pattern.compile(Pincode_REGEX);
		if (value == null) {
			return false;
		}
		matcher = pattern.matcher(value);
		return matcher.matches();
	}

}
