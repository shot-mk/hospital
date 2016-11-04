package com.nikitab.service.interf

import com.nikitab.domain.dto.UserDTO
import com.nikitab.domain.entity.security.User
import com.nikitab.service.BaseService
import com.nikitab.service.WithName

interface UserService extends BaseService<User, Long>, WithName<User> {

	User findByEmail(String email)

	void registerNewUser(UserDTO userDTO)

}