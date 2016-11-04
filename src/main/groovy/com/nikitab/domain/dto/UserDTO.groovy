package com.nikitab.domain.dto

import com.nikitab.domain.enums.Gender
import com.nikitab.domain.validation.PasswordMatches
import com.nikitab.domain.validation.ValidEmail
import org.aspectj.weaver.ast.Not
import org.hibernate.validator.constraints.NotEmpty

import javax.validation.constraints.NotNull

@PasswordMatches(passwordFieldNames = ["password", "matchingPassword"])
class UserDTO {

	@NotEmpty
	@NotNull
	String firstName

	@NotEmpty
	@NotNull
	String lastName

	@NotEmpty
	@NotNull
	String userName

	@NotEmpty
	@NotNull
	@ValidEmail
	String email

	@NotEmpty
	@NotNull
	String password

	@NotEmpty
	@NotNull
	String matchingPassword

	@NotNull
	Gender gender

}
