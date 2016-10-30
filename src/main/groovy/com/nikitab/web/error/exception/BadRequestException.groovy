package com.nikitab.web.error.exception

class BadRequestException extends RuntimeException {

	BadRequestException() {
	}

	BadRequestException(String s) {
		super(s)
	}

	BadRequestException(String s, Throwable throwable) {
		super(s, throwable)
	}

	BadRequestException(Throwable throwable) {
		super(throwable)
	}

	BadRequestException(String s, Throwable throwable, boolean b, boolean b1) {
		super(s, throwable, b, b1)
	}

}
