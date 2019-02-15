package com.tomasznajda.rxdao.entity


enum class MappingRule {
    SKIP,
    THROW;

    val isSkip: Boolean
        get() = this == SKIP
    val isThrow: Boolean
        get() = this == THROW
}