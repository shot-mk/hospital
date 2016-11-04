package com.nikitab.web.error

import com.nikitab.web.error.dto.ApiError
import com.nikitab.web.error.exception.BadRequestException
import com.nikitab.web.error.exception.EmailAlreadyInUserException
import com.nikitab.web.error.exception.UsernameAlreadyInUseException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	Logger LOGGER = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class)

	RestResponseEntityExceptionHandler() {
		super()
	}

	@Override
	ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleExceptionInternal(ex, getMessage(HttpStatus.BAD_REQUEST, ex), headers, HttpStatus.BAD_REQUEST, request)
	}

	@Override
	ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleExceptionInternal(ex, getMessage(HttpStatus.BAD_REQUEST, ex), headers, HttpStatus.BAD_REQUEST, request)
	}

	@ExceptionHandler(value = [DataIntegrityViolationException.class, BadRequestException.class])
	ResponseEntity<Object> handleBadRequest(DataIntegrityViolationException ex, WebRequest request) {
		return handleExceptionInternal(ex, getMessage(HttpStatus.BAD_REQUEST, ex), new HttpHeaders(), HttpStatus.BAD_REQUEST, request)
	}

	@ExceptionHandler(value = [UsernameAlreadyInUseException.class, EmailAlreadyInUserException.class])
	ResponseEntity<Object> handleUserRegistration(DataIntegrityViolationException ex, WebRequest request) {
		return handleExceptionInternal(ex, getMessage(HttpStatus.BAD_REQUEST, ex), new HttpHeaders(), HttpStatus.BAD_REQUEST, request)
	}

	private ApiError getMessage(HttpStatus status, Exception ex) {
		String message = ex.message
		Throwable rootCause = getCause(ex)
		String devMessage = rootCause.class.name + ":" + rootCause.message
		return new ApiError(status.value(), message, devMessage)
	}

	Throwable getCause(Throwable e) {
		Throwable cause = null;
		Throwable result = e;
		while(null != (cause = result.getCause())  && (result != cause) ) {
			result = cause;
		}
		return result;
	}

}
