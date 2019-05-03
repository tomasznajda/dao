package com.tomasznajda.rxdao.dbflow

import com.raizlabs.android.dbflow.config.DatabaseDefinition
import com.raizlabs.android.dbflow.config.FlowManager
import com.tomasznajda.rxdao.dao.BaseDao
import com.tomasznajda.rxdao.entity.MappingRule
import com.tomasznajda.rxdao.query.Action
import com.tomasznajda.rxdao.query.Query
import kotlin.reflect.KClass

abstract class BaseDbFlowDao<EntityT : Any, ModelT : Any>(private val dbClass: KClass<*>)
    : BaseDao<DatabaseDefinition, EntityT, ModelT>() {

    protected val db by lazy { FlowManager.getDatabase(dbClass.java) }

    override fun execute(action: Action<DatabaseDefinition>) = action.execute(db)

    override fun execute(query: Query<DatabaseDefinition, ModelT>, mappingRule: MappingRule) =
        query.execute(db).map {
            if (mappingRule.isThrow) mapper.toEntitiesOrThrow(it)
            else mapper.toEntitiesOrSkip(it)
        }!!
}
