package com.tomasznajda.rxdao.dbflow

import android.content.res.AssetManager
import com.tomasznajda.rxdao.dao.BaseDao
import com.tomasznajda.rxdao.entity.MappingRule
import com.tomasznajda.rxdao.query.Action
import com.tomasznajda.rxdao.query.Query

abstract class BaseAssetsDao<EntityT : Any, ModelT : Any>
    : BaseDao<AssetManager, EntityT, ModelT>() {

    abstract val assets: AssetManager

    override fun execute(action: Action<AssetManager>) = action.execute(assets)

    override fun execute(query: Query<AssetManager, ModelT>, mappingRule: MappingRule) =
        query.execute(assets).map {
            if (mappingRule.isThrow) mapper.toEntitiesOrThrow(it)
            else mapper.toEntitiesOrSkip(it)
        }!!
}
