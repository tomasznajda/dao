package com.tomasznajda.rxdao.dao

import com.tomasznajda.rxdao.RxDao
import com.tomasznajda.rxdao.entity.MappingRule
import com.tomasznajda.rxdao.mapper.Mapper
import com.tomasznajda.rxdao.query.Action
import com.tomasznajda.rxdao.query.Query
import io.reactivex.Completable
import io.reactivex.Observable

abstract class BaseDao<ExecutorT, EntityT : Any, ModelT : Any> {

    abstract val mapper: Mapper<EntityT, ModelT>

    abstract fun execute(action: Action<ExecutorT>): Completable
    abstract fun execute(query: Query<ExecutorT, ModelT>,
                         mappingRule: MappingRule = RxDao.defaultMappingRule): Observable<List<EntityT>>
}