package com.darioossa.melitest.ui.navigation

sealed class Screen(val route: String) {
    object Search: Screen("search")
    object Results: Screen("items?$ARG_SEARCH_TEXT={$ARG_SEARCH_TEXT}")
    object Detail: Screen("items/{$ARG_ITEM_ID}")
    
    companion object {
        const val ARG_SEARCH_TEXT = "query"
        const val ARG_ITEM_ID = "itemId"
    }
}
