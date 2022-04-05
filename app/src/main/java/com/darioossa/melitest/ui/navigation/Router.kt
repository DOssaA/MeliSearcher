package com.darioossa.melitest.ui.navigation

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.darioossa.melitest.ui.navigation.Screen.Companion.ARG_ITEM_ID
import com.darioossa.melitest.ui.navigation.Screen.Companion.ARG_SEARCH_TEXT

class Router(
    val navHostController: NavHostController,
    private val context: Context
) {
    val navigateToResults: (search: String) -> Unit = {
        navHostController.navigate(Screen.Results.route.replace("{$ARG_SEARCH_TEXT}", it))
    }
    val navigateToDetail: (itemId: String) -> Unit = {
        navHostController.navigate(Screen.Detail.route.replace("{$ARG_ITEM_ID}", it))
    }
    val navigateBack: () -> Unit = {
        if (!navHostController.popBackStack()) (context as? Activity)?.finish()
    }
}

@Composable
fun rememberRouter(
    navHostController: NavHostController = rememberNavController(),
    context: Context = LocalContext.current
) = remember {
    Router(navHostController, context)
}