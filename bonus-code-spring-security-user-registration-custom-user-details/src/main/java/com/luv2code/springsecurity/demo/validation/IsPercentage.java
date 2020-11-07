package com.luv2code.springsecurity.demo.validation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PercentageValidator.class)
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IsPercentage {
	String message() default "Input must be a valid percentage(0.0-100.0).";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
