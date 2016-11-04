package com.nikitab.service.interf

import com.nikitab.domain.entity.human.Doctor
import com.nikitab.service.BaseService
import com.nikitab.service.WithName

interface DoctorService extends BaseService<Doctor, Long>, WithName<Doctor> {

}