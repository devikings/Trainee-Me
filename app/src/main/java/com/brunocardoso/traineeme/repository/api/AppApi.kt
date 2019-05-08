package com.brunocardoso.traineeme.repository.api

import com.brunocardoso.traineeme.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

abstract class AppApi {
    companion object {
        private var instance: Retrofit? = null

        fun getInstance(): Retrofit? {
            if(instance == null){
                instance = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
            }

            return instance
        }
    }
}