package com.nikitab.domain.entity.human

import com.nikitab.domain.entity.BaseModel
import com.nikitab.domain.enums.Gender
import groovy.transform.Canonical

import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
@Canonical
class Person extends BaseModel {

	@Column(name = "name", length = 50, nullable = false)
	String name

	@Column(name = "surname", length = 50, nullable = false)
	String surname

	@Column(name = "age", nullable = false)
	@Min(0L)
	@Max(120L)
	int age

	@Column(name = "gender", length = 6, nullable = false)
	@Enumerated(EnumType.STRING)
	Gender gender

}
