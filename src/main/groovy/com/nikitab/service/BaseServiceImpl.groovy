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
abstract class BaseServiceImpl<MODEL extends BaseModel, ID extends Serializable> implements BaseService<MODEL, ID> {

	protected JpaRepository<MODEL, ID> repository

	@Autowired
	public void setRepository(JpaRepository<MODEL, ID> repository) {
		this.repository = repository
	}

	@Override
	public <S extends MODEL> S save(S model){
		repository.save(model)
	}

	@Override
	public <S extends MODEL> S update(S model) {
		repository.save(model)
	}

	@Override
	public void deleteById(ID id) {
		repository.delete(id)
	}

	@Override
	public <S extends MODEL> void delete(S model) {
		repository.delete(model)
	}

	@Override
	public MODEL findOne(ID id) {
		repository.findOne(id)
	}

	@Override
	public List<MODEL> findAll() {
		repository.findAll()
	}

	@Override
	public List<MODEL> findAll(Sort sort) {
		repository.findAll(sort)
	}

	@Override
	public Page<MODEL> findAll(Pageable pageable) {
		repository.findAll(pageable)
	}

}
