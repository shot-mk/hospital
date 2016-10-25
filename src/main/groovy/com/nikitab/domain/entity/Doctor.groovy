package com.nikitab.domain.entity

import com.nikitab.domain.enums.DoctorSpecialization
import com.nikitab.domain.enums.Gender
import groovy.transform.Canonical

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Entity
@Canonical
@Table(name = "doctor")
class Doctor {

    @Id
    @GeneratedValue
    long id

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

    @Column(name = "specialization", length = 100, nullable = false)
    @Enumerated(EnumType.STRING)
    DoctorSpecialization specialization


}
