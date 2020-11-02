package com.luv2code.springsecurity.demo.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileValidator implements ConstraintValidator<ValidMobileNumber, String> {

	private Pattern pattern;
	private Matcher matcher;
	private static final String MOBILE_NUMBER = "(0/91)?[7-9][0-9]{9}";

	@Override
	public boolean isValid(final String mobileNumber, final ConstraintValidatorContext context) {
		pattern = Pattern.compile(MOBILE_NUMBER);
		if (mobileNumber == null) {
			return true;
		}
		matcher = pattern.matcher(mobileNumber);
		return matcher.matches();
	}

}