package com.darioossa.melitest.domain

import com.darioossa.melitest.UseCaseTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class SearchTextUseCaseTest: UseCaseTest() {

    private lateinit var useCase: SearchTextUseCase
    private val dataSource = mockk<SearchDataSource>()

    @Before
    fun setUp() {
        useCase = SearchTextUseCase(dataSource, dispatcher)
    }

    @Test
    fun run() = runBlocking {
        coEvery { dataSource.getResults("laptop") } returns flow { emit(listOf()) }
        useCase("laptop")
        coVerify { dataSource.getResults("laptop") }
    }
}