package com.darioossa.melitest.data.remote

import com.darioossa.melitest.domain.entity.SearchResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SearchApi {

    @GET(GET_RESULTS)
    suspend fun getResults(
        @Query(TERM) query: String
    ): SearchRawResult

    @GET(GET_ITEM_DETAIL)
    suspend fun getDetail(@Path(ITEM_ID) itemId: String): SearchResult

    companion object {
        const val TERM = "q"
        const val GET_RESULTS = "sites/MLA/search"
        const val ITEM_ID = "id"
        const val GET_ITEM_DETAIL = "items/{$ITEM_ID}"
    }
}