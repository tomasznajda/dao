package com.tomasznajda.rxdao.retrofit

import com.tomasznajda.rxdao.dao.BaseDao
import com.tomasznajda.rxdao.entity.MappingRule
import com.tomasznajda.rxdao.query.Action
import com.tomasznajda.rxdao.query.Query
import retrofit2.Retrofit

abstract class BaseRetrofitDao<EntityT : Any, ModelT : Any> : BaseDao<Retrofit, EntityT, ModelT>() {

    abstract val retrofitFactory: RetrofitFactory
    protected val retrofit by lazy { retrofitFactory.create() }

    override fun execute(action: Action<Retrofit>) = action.execute(retrofit)

    override fun execute(query: Query<Retrofit, ModelT>, mappingRule: MappingRule) =
        query.execute(retrofit).map {
            if (mappingRule.isThrow) mapper.toEntitiesOrThrow(it)
            else mapper.toEntitiesOrSkip(it)
        }!!
}