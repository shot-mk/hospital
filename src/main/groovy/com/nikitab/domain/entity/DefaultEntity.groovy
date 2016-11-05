package com.nikitab.domain.entity

import groovy.transform.AnnotationCollector
import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode

import javax.persistence.Entity

@Canonical
@Entity
@EqualsAndHashCode(includes = "id")
@AnnotationCollector
@interface DefaultEntity {

}