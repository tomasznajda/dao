package com.tomasznajda.rxdao.retrofit

import retrofit2.Retrofit

interface RetrofitFactory {

    fun create(): Retrofit
}