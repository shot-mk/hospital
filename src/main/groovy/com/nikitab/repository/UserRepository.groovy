package com.nikitab.repository

import com.nikitab.domain.entity.security.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username)

}