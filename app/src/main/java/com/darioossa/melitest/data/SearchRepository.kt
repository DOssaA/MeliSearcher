package com.darioossa.melitest.data

import com.darioossa.melitest.data.remote.SearchRemoteDataSource
import com.darioossa.melitest.domain.SearchDataSource
import com.darioossa.melitest.domain.entity.SearchResult
import kotlinx.coroutines.flow.Flow

class SearchRepository(private val remote: SearchRemoteDataSource): SearchDataSource {
    override suspend fun getResults(query: String): Flow<List<SearchResult>> =
        remote.getResults(query)
}