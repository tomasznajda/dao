package com.tomasznajda.rxdao.query

import io.reactivex.Observable

interface Query<ExecutorT, ModelT> {

    fun execute(executor: ExecutorT): Observable<List<ModelT>>
}