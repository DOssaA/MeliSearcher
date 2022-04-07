package com.darioossa.melitest.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET(GET_RESULTS)
    suspend fun getResults(
        @Query(TERM) query: String
    ): SearchRawResult

    companion object {
        const val TERM = "q"
        const val GET_RESULTS = "search"
    }
}