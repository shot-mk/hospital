package com.nikitab.domain.entity.human

import com.nikitab.domain.entity.DefaultEntity
import com.nikitab.domain.entity.schedule.Schedule

import javax.persistence.*
import java.time.LocalDate

@DefaultEntity
@Table(name = "employee")
@PrimaryKeyJoinColumn(name = "id")
class Employee extends Person {

    @Column(name = "salary")
    BigDecimal salary;

    @Column(name = "date_beginning_of_work", nullable = false)
    LocalDate beginningOfWork;

    @Column(name = "date_end_of_work")
    LocalDate endOfWork;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
    List<Schedule> schedules

}
