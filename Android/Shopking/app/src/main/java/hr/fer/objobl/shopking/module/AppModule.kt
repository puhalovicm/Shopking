package hr.fer.objobl.shopking.module

import androidx.appcompat.app.AppCompatActivity
import hr.fer.objobl.shopking.data.source.ArticleDataSource
import hr.fer.objobl.shopking.data.source.CategoryDataSource
import hr.fer.objobl.shopking.navigation.NavigationManager
import hr.fer.objobl.shopking.navigation.NavigationManagerImpl
import hr.fer.objobl.shopking.viewmodel.CatalogueViewModel
import hr.fer.objobl.shopking.viewmodel.MainActivityViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {

    factory<NavigationManager> {
        val activity: AppCompatActivity = it[0]
        NavigationManagerImpl(activity)
    }

    single {
        ArticleDataSource()
    }

    single {
        CategoryDataSource()
    }

    viewModel {
        val navigationManager: NavigationManager = it[0]
        MainActivityViewModel(navigationManager)
    }

    viewModel {
        CatalogueViewModel(get(), get())
    }
}
