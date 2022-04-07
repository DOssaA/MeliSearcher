package com.darioossa.melitest.domain

import com.darioossa.melitest.domain.entity.SearchResult
import com.darioossa.melitest.domain.util.Result
import com.darioossa.melitest.domain.util.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class SearchTextUseCase(
    private val dataSource: SearchDataSource,
    dispatcher: CoroutineDispatcher
): UseCase<Flow<List<SearchResult>>, String>(dispatcher) {

    override suspend fun run(params: String): Result<Flow<List<SearchResult>>> =
        Result.Success(dataSource.getResults(params))
}