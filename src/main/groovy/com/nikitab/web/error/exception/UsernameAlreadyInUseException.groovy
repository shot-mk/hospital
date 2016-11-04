package com.nikitab.web.error.exception

class UsernameAlreadyInUseException extends RuntimeException {

	UsernameAlreadyInUseException() {
	}

	UsernameAlreadyInUseException(String s) {
		super(s)
	}

}
