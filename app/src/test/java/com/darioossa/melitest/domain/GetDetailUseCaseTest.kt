package com.darioossa.melitest.domain

import com.darioossa.melitest.UseCaseTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetDetailUseCaseTest: UseCaseTest() {

    private lateinit var useCase: GetDetailUseCase
    private val dataSource = mockk<SearchDataSource>()

    @Before
    fun setUp() {
        useCase = GetDetailUseCase(dataSource, dispatcher)
    }

    @Test
    fun run() = runBlocking {
        val id = "234"
        coEvery { dataSource.getDetail(id) }
        useCase(id)
        coVerify { dataSource.getDetail(id) }
    }
}