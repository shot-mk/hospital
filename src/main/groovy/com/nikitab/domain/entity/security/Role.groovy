package com.nikitab.domain.entity.security

import com.nikitab.domain.entity.DefaultEntity
import com.nikitab.domain.entity.BaseModel

import javax.persistence.*

@DefaultEntity
@Table(name = "role")
class Role extends BaseModel {

	@Column(name = "name")
	String name

	@ManyToMany(mappedBy = "roles")
	Set<User> users

	@ManyToMany
	@JoinTable(name = "role_privilege",
			joinColumns = [@JoinColumn(name = "role_id", referencedColumnName = "id")],
			inverseJoinColumns = [@JoinColumn(name = "privilege_id", referencedColumnName = "id")]
	)
	Set<Privilege> privileges

}
