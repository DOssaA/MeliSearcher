package com.darioossa.melitest.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {

    fun <T: Any> getService(
        url: String,
        service: Class<T>,
        client: OkHttpClient = OkHttpClient.Builder().build()
    ): T = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(url)
        .client(client)
        .build()
        .create(service)
}