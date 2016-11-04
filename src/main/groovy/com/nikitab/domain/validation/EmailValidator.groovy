package com.nikitab.domain.validation

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import java.util.regex.Matcher
import java.util.regex.Pattern

class EmailValidator implements ConstraintValidator<ValidEmail, String> {

	private static final String EMAIL_PATTERN = '''^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})''';
	private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	private Matcher matcher;

	@Override
	void initialize(ValidEmail constraintAnnotation) {

	}

	@Override
	boolean isValid(String value, ConstraintValidatorContext context) {
		if (!value) {
			return false
		}
		matcher = pattern.matcher(value)
		matcher.matches()
	}

}
