package com.darioossa.melitest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.darioossa.melitest.ui.detail.DetailScreen
import com.darioossa.melitest.ui.navigation.Screen.Companion.ARG_ITEM_ID
import com.darioossa.melitest.ui.navigation.Screen.Companion.ARG_SEARCH_TEXT
import com.darioossa.melitest.ui.results.ResultsScreen
import com.darioossa.melitest.ui.search.SearchScreen
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable 
fun NavGraph(
    startRoute: String = Screen.Search.route,
    router: Router = rememberRouter()
) {
    NavHost(navController = router.navHostController, startDestination = startRoute) {
        composable(Screen.Search.route) {
            SearchScreen(onSubmit = router.navigateToResults, viewModel = getViewModel())
        }
        composable(
            route = Screen.Results.route,
            arguments = listOf(navArgument(ARG_SEARCH_TEXT) {
                type = NavType.StringType
                defaultValue = ""
            })
        ) {
            val searchText = it.arguments?.getString(ARG_SEARCH_TEXT).orEmpty()
            ResultsScreen(getViewModel(parameters = {
                parametersOf(searchText)
            }), searchText, router.navigateBack, router.navigateToDetail)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument(ARG_ITEM_ID) { type = NavType.StringType })
        ) {
            val itemId = it.arguments?.getString(ARG_ITEM_ID)
            DetailScreen(getViewModel(parameters = {
                parametersOf(itemId)
            }), router.navigateBack)
        }
    }
}