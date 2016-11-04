package com.nikitab.service

import com.nikitab.domain.entity.BaseModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

interface BaseService<MODEL extends BaseModel, ID extends Serializable> {

	public <S extends MODEL> S save(S model)

	public <S extends MODEL> S update(S model)

	public void deleteById(ID id)

	public <S extends MODEL> void delete(S model)

	public MODEL findOne(ID id)

	public List<MODEL> findAll()

	public List<MODEL> findAll(Sort sort)

	public Page<MODEL> findAll(Pageable pageable)

}