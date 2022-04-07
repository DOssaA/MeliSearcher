package com.darioossa.melitest.domain.util

import com.darioossa.melitest.BuildConfig
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class UseCase<T: Any, in Params>(
    private val dispatcher: CoroutineDispatcher
) {
    protected abstract suspend fun run(params: Params): Result<T>

    suspend operator fun invoke(params: Params): Result<T> = withContext(dispatcher) {
        try {
            run(params)
        } catch (e: Throwable) {
            if (BuildConfig.DEBUG) e.printStackTrace()
            Result.Error(e)
        }
    }
}