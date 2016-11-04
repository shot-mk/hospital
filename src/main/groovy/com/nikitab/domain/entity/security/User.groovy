package com.nikitab.domain.entity.security

import com.nikitab.domain.entity.BaseModel
import com.nikitab.domain.entity.human.Person
import com.nikitab.domain.validation.ValidEmail
import groovy.transform.Canonical
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

import javax.persistence.*
import javax.validation.constraints.NotNull
import java.util.stream.Collectors

@Entity
@Table(name = "user")
@Canonical
class User extends BaseModel implements UserDetails {

	@OneToOne(cascade = [CascadeType.MERGE, CascadeType.PERSIST])
	@JoinColumn(name = "person_id")
	Person person

	@Column(name = "username")
	String username

	@Column(name = "password_hash")
	String password

	@Column(name = "email")
	@NotNull
	@ValidEmail
	String email

	@Column(name = "account_non_expired")
	boolean accountNonExpired = true

	@Column(name = "account_non_locked")
	boolean accountNonLocked = true

	@Column(name = "credentials_non_expired")
	boolean credentialsNonExpired = true

	@Column(name = "enabled")
	boolean enabled = true


	@ManyToMany
	@JoinTable(name = "user_role",
			joinColumns = [@JoinColumn(name = "user_id", referencedColumnName = "id")],
			inverseJoinColumns = [@JoinColumn(name = "role_id", referencedColumnName = "id")]
	)
	List<Role> roles = new ArrayList<>()

	@Override
	Collection<? extends GrantedAuthority> getAuthorities() {
		roles.stream().flatMap { g -> g.privileges.name }.collect(Collectors.toList())
	}

	@Override
	String getPassword() {
		password
	}

	@Override
	String getUsername() {
		username
	}

	@Override
	boolean isAccountNonExpired() {
		accountNonExpired
	}

	@Override
	boolean isAccountNonLocked() {
		accountNonLocked
	}

	@Override
	boolean isCredentialsNonExpired() {
		credentialsNonExpired
	}

	@Override
	boolean isEnabled() {
		enabled
	}

}
