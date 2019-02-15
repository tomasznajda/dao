package com.tomasznajda.rxdao

import com.tomasznajda.rxdao.entity.MappingRule

object RxDao {

    val errorHandler: (Throwable) -> Unit = { it.printStackTrace() }
    val mappingRule = MappingRule.THROW
}