package com.darioossa.melitest.data

import android.util.Log
import com.darioossa.melitest.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {

    fun <T: Any> getService(
        url: String,
        service: Class<T>,
        client: OkHttpClient = getClient()
    ): T = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(url)
        .client(client)
        .build()
        .create(service)

    private fun getClient(): OkHttpClient =

        OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG)
                addInterceptor(HttpLoggingInterceptor{
                    Log.i("HttpLoggingInterceptor", "Network request")
                }.setLevel(HttpLoggingInterceptor.Level.BODY))
        }.build()
}