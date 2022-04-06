package com.darioossa.melitest.injection

import com.darioossa.melitest.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Injection {
    val presentationModule = module {
        viewModel { SearchViewModel() }
    }
}