package com.nikitab.domain.entity.schedule

import com.nikitab.domain.entity.human.Employee
import groovy.transform.Canonical

import javax.persistence.*
import java.time.LocalDate
import java.time.LocalTime

@Entity
@Table(name = "schedule")
@Canonical
class Schedule {

	@Id
	@GeneratedValue
	long id

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	Employee employee

	@Column(name = "date")
	LocalDate date

	@Column(name = "time_start")
	LocalTime timeStart

	@Column(name = "time_end")
	LocalTime timeEnd

}
