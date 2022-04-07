package com.darioossa.melitest.data.remote

import com.darioossa.melitest.domain.entity.SearchResult
import kotlinx.coroutines.flow.Flow

interface SearchRemoteDataSource {
    suspend fun getResults(query: String): Flow<List<SearchResult>>
}