package com.darioossa.melitest.domain

import com.darioossa.melitest.domain.entity.SearchResult
import kotlinx.coroutines.flow.Flow

interface SearchDataSource {
    suspend fun getResults(query: String): Flow<List<SearchResult>>
}