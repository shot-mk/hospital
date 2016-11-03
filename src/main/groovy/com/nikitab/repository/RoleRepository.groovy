package com.nikitab.repository

import com.nikitab.domain.entity.security.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String name)

}