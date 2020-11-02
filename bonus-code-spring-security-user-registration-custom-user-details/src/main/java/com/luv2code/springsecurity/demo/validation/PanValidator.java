package com.luv2code.springsecurity.demo.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PanValidator implements ConstraintValidator<IsPan, String> {

	private Pattern pattern;
	private Matcher matcher;
	private static final String PAN_REGEX = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
	@Override
	public boolean isValid(final String value,final ConstraintValidatorContext context) {
		pattern = Pattern.compile(PAN_REGEX);
		if (value == null) {
			return false;
		}
		matcher = pattern.matcher(value);
		return matcher.matches();
	}

}
