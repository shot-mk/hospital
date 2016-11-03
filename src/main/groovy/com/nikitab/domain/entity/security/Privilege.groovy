package com.nikitab.domain.entity.security

import com.nikitab.domain.entity.BaseModel
import groovy.transform.Canonical

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "privilege")
@Canonical
class Privilege extends BaseModel {

	@Column(name = "name")
	String name

}
