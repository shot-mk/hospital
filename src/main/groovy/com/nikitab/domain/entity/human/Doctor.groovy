package com.nikitab.domain.entity.human

import com.nikitab.domain.enums.DoctorSpecialization
import groovy.transform.Canonical

import javax.persistence.*

@Entity
@Canonical
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "doctor")
class Doctor extends Employee {

    @Column(name = "specialization", length = 100, nullable = false)
    @Enumerated(EnumType.STRING)
    DoctorSpecialization specialization
	
}
