package com.nikitab.repository

import com.nikitab.domain.entity.Doctor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface DoctorRepository extends JpaRepository<Doctor, Long> {

}