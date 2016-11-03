package com.nikitab.repository

import com.nikitab.domain.entity.security.Privilege
import org.springframework.data.jpa.repository.JpaRepository

interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

	Privilege findByName(String name)

}