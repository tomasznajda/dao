package com.tomasznajda.rxdao.retrofit

import com.tomasznajda.rxdao.query.Query
import retrofit2.Retrofit

interface RetrofitQuery<ModelT> : Query<Retrofit, ModelT>