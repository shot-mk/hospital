package com.nikitab.web.error.exception

class ResourceNotFoundException extends RuntimeException {

	ResourceNotFoundException() {
	}

	ResourceNotFoundException(String s) {
		super(s)
	}

	ResourceNotFoundException(String s, Throwable throwable) {
		super(s, throwable)
	}

	ResourceNotFoundException(Throwable throwable) {
		super(throwable)
	}

	ResourceNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
		super(s, throwable, b, b1)
	}

}
