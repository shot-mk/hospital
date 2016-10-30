package com.nikitab.service

import com.nikitab.domain.entity.BaseModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository

/**
 * All CRUD operations.
 * Methods here will work without any external configuration
 * if proper repository bean is registered in context
 *
 * @param <MODEL> entity that is managed by this service
 */
abstract class BaseService<MODEL extends BaseModel, ID extends Serializable> {

	JpaRepository<MODEL, ID> repository

	@Autowired
	public void setRepository(JpaRepository<MODEL, ID> repository) {
		this.repository = repository
	}

	public <S extends MODEL> S save(S model){
		repository.save(model)
	}

	public <S extends MODEL> S update(S model) {
		repository.save(model)
	}

	public void deleteById(ID id) {
		repository.delete(id)
	}

	public <S extends MODEL> void delete(S model) {
		repository.delete(model)
	}

	public MODEL findOne(ID id) {
		repository.findOne(id)
	}

	public List<MODEL> findAll() {
		repository.findAll()
	}

	public List<MODEL> findAll(Sort sort) {
		repository.findAll(sort)
	}

	public Page<MODEL> findAll(Pageable pageable) {
		repository.findAll(pageable)
	}

}
