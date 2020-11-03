package com.luv2code.springsecurity.demo.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GstinValidator implements ConstraintValidator<IsGstin, String> {

	private Pattern pattern;
	private Matcher matcher;
	private static final String GSTIN_REGEX = "^[0-9]{2}[A-Z]{5}[0-9]{4}"
            + "[A-Z]{1}[1-9A-Z]{1}"
            + "Z[0-9A-Z]{1}$";
	@Override
	public boolean isValid(final String value,final ConstraintValidatorContext context) {
		pattern = Pattern.compile(GSTIN_REGEX);
		if (value == null) {
			return true;
		}
		matcher = pattern.matcher(value);
		return matcher.matches();
	}

}
