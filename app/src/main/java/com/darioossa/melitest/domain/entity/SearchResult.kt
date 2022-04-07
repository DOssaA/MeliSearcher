package com.darioossa.melitest.domain.entity

data class SearchResult(
    val id: String,
    val title: String,
    val thumbnail: String,
    val price: String,
    val currency_id: String
)