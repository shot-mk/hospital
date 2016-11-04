package com.nikitab.domain.validation

import javax.validation.Constraint
import javax.validation.Payload
import java.lang.annotation.Documented
import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target


@Target([ElementType.FIELD, ElementType.TYPE, ElementType.ANNOTATION_TYPE])
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
@interface ValidEmail {

	String message() default "Invalid email"
	Class<?>[] groups() default [];
	Class<? extends Payload>[] payload() default [];

}