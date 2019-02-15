package com.tomasznajda.rxdao.query

import io.reactivex.Observable

interface Query<ExecutorT, EntityT> {

    fun execute(executor: ExecutorT): Observable<List<EntityT>>
}