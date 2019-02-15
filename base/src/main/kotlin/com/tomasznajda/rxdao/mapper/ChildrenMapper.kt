package com.tomasznajda.rxdao.mapper

import com.tomasznajda.rxdao.RxDao

abstract class ChildrenMapper<ParentIdT : Any, EntityT : Any, ModelT : Any> {

    abstract fun toEntity(parentId: ParentIdT, model: ModelT): EntityT
    abstract fun toModel(parentId: ParentIdT, entity: EntityT): ModelT

    fun toEntitiesOrSkip(parentId: ParentIdT, models: Iterable<ModelT>) =
            models.mapNotNull { model -> safe { toEntity(parentId, model) } }

    fun toModelsOrSkip(parentId: ParentIdT, entities: Iterable<EntityT>) =
            entities.mapNotNull { entity -> safe { toModel(parentId, entity) } }

    fun toEntitiesOrThrow(parentId: ParentIdT, models: Iterable<ModelT>) =
            models.map { toEntity(parentId, it) }

    fun toModelsOrThrow(parentId: ParentIdT, entities: Iterable<EntityT>) =
            entities.map { toModel(parentId, it) }

    private fun <T> safe(block: () -> T): T? =
            try {
                block()
            } catch (exception: Exception) {
                RxDao.errorHandler(exception)
                null
            }
}
