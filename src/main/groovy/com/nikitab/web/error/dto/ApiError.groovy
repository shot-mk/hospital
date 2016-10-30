package com.nikitab.web.error.dto

import groovy.transform.Canonical

@Canonical
class ApiError {

	int status

	String message

	String devMessage

}
