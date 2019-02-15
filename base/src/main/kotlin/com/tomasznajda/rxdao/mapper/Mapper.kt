package com.tomasznajda.rxdao.mapper

import com.tomasznajda.rxdao.RxDao

abstract class Mapper<EntityT : Any, ModelT : Any> {

    abstract fun toEntity(model: ModelT): EntityT
    abstract fun toModel(entity: EntityT): ModelT

    fun toEntitiesOrSkip(models: Iterable<ModelT>) =
            models.mapNotNull { model -> safe { toEntity(model) } }

    fun toModelsOrSkip(entities: Iterable<EntityT>) =
            entities.mapNotNull { entity -> safe { toModel(entity) } }

    fun toEntitiesOrThrow(models: Iterable<ModelT>) = models.map { toEntity(it) }

    fun toModelsOrThrow(entities: Iterable<EntityT>) = entities.map { toModel(it) }

    private fun <T> safe(block: () -> T): T? =
            try {
                block()
            } catch (exception: Exception) {
                RxDao.errorHandler(exception)
                null
            }
}