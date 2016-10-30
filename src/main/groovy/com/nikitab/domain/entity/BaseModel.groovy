package com.nikitab.domain.entity

import groovy.transform.Canonical

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

/**
 * Should be used as superclass of every entity.
 */
@MappedSuperclass
@Canonical
abstract class BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

}
