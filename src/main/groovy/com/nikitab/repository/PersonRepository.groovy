package com.nikitab.repository

import com.nikitab.domain.entity.human.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository extends JpaRepository<Person, Long> {

}