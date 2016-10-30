package com.nikitab.repository

import com.nikitab.domain.entity.schedule.Schedule
import org.springframework.data.jpa.repository.JpaRepository

interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}