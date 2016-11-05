package com.nikitab.repository

import com.nikitab.domain.entity.security.User
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username)

	@EntityGraph(value = "graph.User.fetched")
	@Query("SELECT u FROM User u WHERE u.username = (:username)")
	User findByUsernameEagerly(@Param("username")String username)

	User findByEmail(String email)

}