package com.nikitab.web.error

import com.nikitab.web.error.exception.BadRequestException
import com.nikitab.web.error.exception.ResourceNotFoundException

class RestPreconditions {

	/**
	 * Suppose to be used for checking if resource exists in system
	 *
	 * @param reference an object reference
	 * @throws ResourceNotFoundException if {@code reference} is null
	 */
	static void checkNotNull(def reference) {
		checkNotNull(reference, null)
	}

	/**
	 * Suppose to be used for checking if resource exists in system
	 *
	 * @param reference an object reference
	 * @param message the message of the exception if check fails
	 * @throws ResourceNotFoundException if {@code reference} is null
	 */
	static void checkNotNull(def reference, String message) {
		if (reference == null) {
			throw new ResourceNotFoundException(message)
		}
		reference
	}

	/**
	 * Suppose to be used for checking if method argument is not null
	 *
	 * @param reference an method argument reference
	 * @throws BadRequestException if {@code reference} is null
	 */
	static void checkMethodArgumentNotNull(def reference) {
		checkMethodArgumentNotNull(reference, null)
	}

	/**
	 * Suppose to be used for checking if method argument is not null
	 *
	 * @param reference an method argument reference
	 * @param message the message of the exception if check fails
	 * @throws BadRequestException if {@code reference} is null
	 */
	static void checkMethodArgumentNotNull(def reference, String message) {
		if (reference == null) {
			throw new BadRequestException(message)
		}
		reference
	}

	/**
	 * Suppose to be used for checking validity of request
	 *
	 * @param expression a boolean expression
	 * @throws BadRequestException if {@code reference} is null
	 */
	static void checkIfBadRequest(boolean expression) {
		checkIfBadRequest(expression, null)
	}

	/**
	 * Suppose to be used for checking validity of request
	 *
	 * @param expression a boolean expression
	 * @param message the message of the exception if check fails
	 * @throws BadRequestException if {@code reference} is null
	 */
	static void checkIfBadRequest(boolean expression, String message) {
		if (!expression) {
			throw new BadRequestException(message)
		}
		expression
	}

}
