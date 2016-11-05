package com.nikitab.domain.entity.human

import com.nikitab.domain.entity.DefaultEntity
import com.nikitab.domain.enums.DoctorSpecialization

import javax.persistence.*

@DefaultEntity
@Table(name = "doctor")
@PrimaryKeyJoinColumn(name = "id")
class Doctor extends Employee {

    @Column(name = "specialization", length = 100, nullable = false)
    @Enumerated(EnumType.STRING)
    DoctorSpecialization specialization
	
}
