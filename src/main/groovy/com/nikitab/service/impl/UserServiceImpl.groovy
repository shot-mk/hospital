package com.nikitab.service.impl

import com.nikitab.domain.dto.UserDTO
import com.nikitab.domain.entity.human.Person
import com.nikitab.domain.entity.security.Role
import com.nikitab.domain.entity.security.User
import com.nikitab.repository.RoleRepository
import com.nikitab.repository.UserRepository
import com.nikitab.service.BaseServiceImpl
import com.nikitab.service.interf.UserService
import com.nikitab.web.error.exception.EmailAlreadyInUserException
import com.nikitab.web.error.exception.UsernameAlreadyInUseException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

	UserRepository userRepository

	RoleRepository roleRepository

	PasswordEncoder passwordEncoder

	@Autowired
	void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository
	}

	@Autowired
	void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository
	}

	@Autowired
	void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder
	}

	@Override
	User findByName(String name) {
		return userRepository.findByUsername(name)
	}

	@Override
	User findByEmail(String email) {
		return userRepository.findByEmail(email)
	}

	@Override
	void registerNewUser(UserDTO userDTO) {
		if (userRepository.findByUsername(userDTO.userName)) {
			throw new UsernameAlreadyInUseException("Username with name " + userDTO.userName + " already exists.")
		}
		if (userRepository.findByEmail(userDTO.userName)) {
			throw new EmailAlreadyInUserException("Email : " + userDTO.email + " already in use.")
		}
		Role userRole = roleRepository.findByName("ROLE_USER")
		Person newPerson = new Person(
				name: userDTO.firstName,
				surname: userDTO.lastName,
				gender: userDTO.gender
		)
		User newUser = new User(
				username: userDTO.userName,
				password: passwordEncoder.encode(userDTO.password),
				email: userDTO.email,
				roles: [userRole],
				person: newPerson
		)
		userRepository.save(newUser)
	}
}
