package com.nikitab.domain.entity.security

import com.nikitab.domain.entity.DefaultEntity
import com.nikitab.domain.entity.BaseModel

import javax.persistence.Column
import javax.persistence.Table

@DefaultEntity
@Table(name = "privilege")
class Privilege extends BaseModel {

	@Column(name = "name")
	String name

}
