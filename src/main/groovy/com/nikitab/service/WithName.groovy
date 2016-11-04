package com.nikitab.service

import com.nikitab.domain.entity.BaseModel

interface WithName<MODEL extends BaseModel> {

	MODEL findByName(String name)

}