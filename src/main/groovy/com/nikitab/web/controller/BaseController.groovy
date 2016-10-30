package com.nikitab.web.controller

import com.nikitab.domain.entity.BaseModel
import com.nikitab.service.BaseService
import com.nikitab.web.error.RestPreconditions
import org.springframework.beans.factory.annotation.Autowired

class BaseController<MODEL extends BaseModel, ID extends Serializable> {

	private BaseService<MODEL, ID> baseService

	@Autowired
	void setService(BaseService<MODEL, ID> service) {
		this.baseService = service
	}

	protected MODEL saveInternal(MODEL model) {
		RestPreconditions.checkMethodArgumentNotNull(model)
		RestPreconditions.checkIfBadRequest(model.id != null)
		baseService.save(model)
	}

	protected MODEL updateInternal(MODEL model, long id) {
		RestPreconditions.checkMethodArgumentNotNull(model)
		RestPreconditions.checkMethodArgumentNotNull(model.id)
		RestPreconditions.checkIfBadRequest(id == model.id, model.class.simpleName + " id, and the URI id don't match")
		RestPreconditions.checkNotNull(baseService.findOne(id))
		baseService.save(model)
	}

	protected void deleteByIdInternal(long id) {
		baseService.deleteById(id)
	}

	protected List<MODEL> findAllInternal() {
		baseService.findAll()
	}

	protected MODEL findOneInternal(ID id) {
		baseService.findOne(id)
	}

}
