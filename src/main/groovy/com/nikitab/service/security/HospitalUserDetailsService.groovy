package com.nikitab.service.security

import com.nikitab.domain.entity.security.User
import com.nikitab.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class HospitalUserDetailsService implements UserDetailsService {

	UserRepository userRepository

	@Autowired
	void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository
	}

	@Override
	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User registeredUser = userRepository.findByUsernameEagerly(username)
		if (!registeredUser) {
			throw new UsernameNotFoundException("No user with this username registered.")
		}
		registeredUser
	}
}
