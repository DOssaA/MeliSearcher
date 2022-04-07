package com.darioossa.melitest.data

import com.darioossa.melitest.data.Constants.BASE_URL
import com.darioossa.melitest.data.remote.SearchApi
import com.darioossa.melitest.data.remote.SearchRemote
import com.darioossa.melitest.data.remote.SearchRemoteDataSource
import com.darioossa.melitest.domain.SearchDataSource
import org.koin.dsl.module

object Injection {
    val dataModule = module {
        single { RetrofitProvider.getService(BASE_URL, SearchApi::class.java) }
        single<SearchRemoteDataSource> { SearchRemote(get()) }
        single<SearchDataSource> { SearchRepository(get()) }
    }
}