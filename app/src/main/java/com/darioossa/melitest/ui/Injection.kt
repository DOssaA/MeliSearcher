package com.darioossa.melitest.ui

import com.darioossa.melitest.ui.results.ResultsViewModel
import com.darioossa.melitest.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Injection {
    val presentationModule = module {
        viewModel { SearchViewModel() }
        viewModel { (text: String) -> ResultsViewModel(text, get()) }
    }
}