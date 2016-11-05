package com.nikitab.domain.entity.schedule

import com.nikitab.domain.entity.DefaultEntity
import com.nikitab.domain.entity.BaseModel
import com.nikitab.domain.entity.human.Employee

import javax.persistence.*
import java.time.LocalDate
import java.time.LocalTime

@DefaultEntity
@Table(name = "schedule")
class Schedule extends BaseModel {

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
