package com.nikitab.domain.validation

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	String[] passwordFieldNames

	@Override
	void initialize(PasswordMatches constraintAnnotation) {
		passwordFieldNames = constraintAnnotation.passwordFieldNames()
	}

	@Override
	boolean isValid(Object value, ConstraintValidatorContext context) {
		return value."${passwordFieldNames[0]}" == value."${passwordFieldNames[1]}"
	}
}
