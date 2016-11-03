package com.nikitab.system.listener

import com.nikitab.domain.entity.security.Privilege
import com.nikitab.domain.entity.security.Role
import com.nikitab.domain.entity.security.User
import com.nikitab.repository.PrivilegeRepository
import com.nikitab.repository.RoleRepository
import com.nikitab.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

/**
 * Bean responsible for creating initial admin user that will be the super user from
 * very beginning, when there is no data in database yet.
 */
@Component
class InitialUsersDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetUp = false

	@Autowired
	PasswordEncoder passwordEncoder

	@Autowired
	UserRepository userRepository

	@Autowired
	RoleRepository roleRepository

	@Autowired
	PrivilegeRepository privilegeRepository


	@Override
	void onApplicationEvent(ContextRefreshedEvent event) {
		if (alreadySetUp) {
			return
		}
		if (userRepository.findByUsername("admin")) {
			alreadySetUp = true
			return
		}
		Privilege superAdminPrivilege = createPrivilegeIfNotFound("SUPER_ADMIN")
		Role superAdminRole = createRoleIfNotFound("ROLE_SUPER_ADMIN", Arrays.asList(superAdminPrivilege))
		createAndSaveSuperAdmin(superAdminRole)
		alreadySetUp = true
	}

	@Transactional
	private createAndSaveSuperAdmin(Role superAdminRole) {
		User superAdmin = new User()
		superAdmin.username = "admin"
		superAdmin.password = passwordEncoder.encode("admin")
		superAdmin.roles << superAdminRole
		userRepository.save(superAdmin)
	}

	@Transactional
	private Role createRoleIfNotFound(String name, List<Privilege> privileges) {
		Role role = roleRepository.findByName(name)
		role ? role : roleRepository.save(new Role(name: name, privileges: privileges))
	}

	@Transactional
	private Privilege createPrivilegeIfNotFound(String name) {
		Privilege privilege = privilegeRepository.findByName(name)
		privilege ? privilege : privilegeRepository.save(new Privilege(name: name))
	}

}
