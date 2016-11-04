package com.nikitab.web.controller.security

import com.nikitab.domain.dto.UserDTO
import com.nikitab.service.interf.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import javax.validation.Valid

@RestController
@RequestMapping("/sec/user-registration")
class UserRegistrationController {

	@Autowired
	UserService userService

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void registerNewUser(@RequestBody @Valid UserDTO userDto) {
		userService.registerNewUser(userDto)
	}

}
