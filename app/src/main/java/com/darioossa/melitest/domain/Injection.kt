package com.darioossa.melitest.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import org.koin.dsl.module

object Injection {
    private const val DISPATCHER = "DISPATCHER"
    private val Scope.dispatcher: CoroutineDispatcher get() = get(named(DISPATCHER))

    val domainModule = module {
        single(named(DISPATCHER)) { Dispatchers.IO }
        factory { SearchTextUseCase(get(), dispatcher) }
        factory { GetDetailUseCase(get(), dispatcher) }
    }
}