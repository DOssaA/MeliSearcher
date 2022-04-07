package com.darioossa.melitest.domain

import com.darioossa.melitest.domain.entity.SearchResult
import com.darioossa.melitest.domain.util.Result
import com.darioossa.melitest.domain.util.UseCase
import kotlinx.coroutines.CoroutineDispatcher

class GetDetailUseCase(
    private val dataSource: SearchDataSource,
    dispatcher: CoroutineDispatcher
): UseCase<SearchResult, String>(dispatcher) {
    override suspend fun run(params: String): Result<SearchResult> =
        Result.Success(dataSource.getDetail(params))
}
