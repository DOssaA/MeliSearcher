package com.darioossa.melitest.data

import com.darioossa.melitest.data.remote.SearchRemoteDataSource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class SearchRepositoryTest {

    private lateinit var repository: SearchRepository
    private val remote = mockk<SearchRemoteDataSource>()

    @Before
    fun setUp() {
        repository = SearchRepository(remote)
    }

    @Test
    fun getResults() = runBlocking {
        coEvery { remote.getResults("hola") } returns flow { emit(listOf()) }
        repository.getResults("hola")
        coVerify { remote.getResults("hola") }
    }
}