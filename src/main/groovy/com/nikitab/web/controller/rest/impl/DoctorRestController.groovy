package com.nikitab.web.controller.rest.impl

import com.nikitab.domain.entity.human.Doctor
import com.nikitab.web.controller.rest.BaseRestController
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@RestController
@RequestMapping(path = "/api/doctors")
class DoctorRestController extends BaseRestController<Doctor, Long> {

	@GetMapping
	List<Doctor> findAll() {
		findAllInternal()
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	void create(@RequestBody @Valid Doctor doctor) {
		saveInternal(doctor)
	}

	@GetMapping("/{id}")
	void findOne(@PathVariable("id") long id) {
		findOneInternal(id)
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	void update(@PathVariable("id") long id, @RequestBody @Valid Doctor doctor) {
		updateInternal(doctor, id)
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void delete(@PathVariable("id") long id) {
		deleteByIdInternal(id)
	}

}
