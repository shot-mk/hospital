package com.nikitab.web.error.exception

class EmailAlreadyInUserException extends RuntimeException {

	EmailAlreadyInUserException() {
	}

	EmailAlreadyInUserException(String s) {
		super(s)
	}

}
