package com.nikitab.domain.entity.security

import com.nikitab.domain.entity.BaseModel
import groovy.transform.Canonical

import javax.persistence.*

@Entity
@Table(name = "role")
@Canonical
class Role extends BaseModel {

	@Column(name = "name")
	String name

	@ManyToMany(mappedBy = "roles")
	List<User> users

	@ManyToMany
	@JoinTable(name = "role_privilege",
			joinColumns = [@JoinColumn(name = "role_id", referencedColumnName = "id")],
			inverseJoinColumns = [@JoinColumn(name = "privilege_id", referencedColumnName = "id")]
	)
	List<Privilege> privileges

}
