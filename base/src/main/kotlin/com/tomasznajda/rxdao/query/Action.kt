package com.tomasznajda.rxdao.query

import io.reactivex.Completable

interface Action<ExecutorT> {

    fun execute(executor: ExecutorT): Completable
}