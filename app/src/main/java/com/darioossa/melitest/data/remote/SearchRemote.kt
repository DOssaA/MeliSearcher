package com.darioossa.melitest.data.remote

import com.darioossa.melitest.domain.entity.SearchResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRemote(private val api: SearchApi): SearchRemoteDataSource {
    override suspend fun getResults(query: String): Flow<List<SearchResult>> = flow {
        emit(api.getResults(query).results)
    }

    override suspend fun getDetail(itemId: String): SearchResult = api.getDetail(itemId)
}