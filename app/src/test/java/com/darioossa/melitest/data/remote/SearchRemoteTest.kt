package com.darioossa.melitest.data.remote

import com.darioossa.melitest.domain.entity.SearchResult
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class SearchRemoteTest {

    private lateinit var remote: SearchRemote
    private val api = mockk<SearchApi>()

    @Before
    fun setUp() {
        remote = SearchRemote(api)
    }

    @Test
    fun getResults() = runBlocking {
        coEvery { api.getResults("query") } returns SearchRawResult(listOf())
        remote.getResults("query").launchIn(this)
        coVerify { api.getResults("query") }
    }

    @Test
    fun getDetails() = runBlocking {
        coEvery { api.getDetail("1") } returns SearchResult("1")
        remote.getDetail("1")
        coVerify { api.getDetail("1") }
    }
}