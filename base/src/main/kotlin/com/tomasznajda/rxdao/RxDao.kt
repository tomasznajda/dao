package com.tomasznajda.rxdao

import com.tomasznajda.rxdao.entity.MappingRule

object RxDao {

    var errorHandler: (Throwable) -> Unit = { it.printStackTrace() }
    var defaultMappingRule = MappingRule.THROW

    fun setup(errorHandler: (Throwable) -> Unit = { it.printStackTrace() },
              defaultMappingRule: MappingRule = MappingRule.THROW) {
        this.errorHandler = errorHandler
        this.defaultMappingRule = defaultMappingRule
    }
}