package com.nikitab.repository

import com.nikitab.domain.entity.human.Doctor
import org.springframework.data.jpa.repository.JpaRepository

interface DoctorRepository extends JpaRepository<Doctor, Long> {

	Doctor findByName(String name)

}