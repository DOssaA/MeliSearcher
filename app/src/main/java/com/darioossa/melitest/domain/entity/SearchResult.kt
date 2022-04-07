package com.darioossa.melitest.domain.entity

data class SearchResult(
    val id: String = "",
    val title: String = "",
    val thumbnail: String = "",
    val price: String = "",
    val currency_id: String = "",
    val tags: List<String> = listOf(),
    val pictures: List<Picture>? = null
)

data class Picture(
    val url: String
)