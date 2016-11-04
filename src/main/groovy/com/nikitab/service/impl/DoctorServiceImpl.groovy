package com.nikitab.service.impl

import com.nikitab.domain.entity.human.Doctor
import com.nikitab.repository.DoctorRepository
import com.nikitab.service.BaseServiceImpl
import com.nikitab.service.interf.DoctorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class DoctorServiceImpl extends BaseServiceImpl<Doctor, Long> implements DoctorService {

	DoctorRepository doctorRepository

	@Autowired
	void setDoctorRepository(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository
	}

	@Override
	Doctor findByName(String name) {
		doctorRepository.findByName(name)
	}
}
