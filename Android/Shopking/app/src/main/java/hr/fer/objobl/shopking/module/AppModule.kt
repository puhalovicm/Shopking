package hr.fer.objobl.shopking.module

import androidx.appcompat.app.AppCompatActivity
import hr.fer.objobl.shopking.data.source.ArticleDataSource
import hr.fer.objobl.shopking.data.source.CategoryDataSource
import hr.fer.objobl.shopking.data.source.RecipeDifficultiesDataSource
import hr.fer.objobl.shopking.data.source.RecipesDataSource
import hr.fer.objobl.shopking.navigation.NavigationManager
import hr.fer.objobl.shopking.navigation.NavigationManagerImpl
import hr.fer.objobl.shopking.viewmodel.CatalogueViewModel
import hr.fer.objobl.shopking.viewmodel.MainActivityViewModel
import hr.fer.objobl.shopking.viewmodel.RecipeDetailsViewModel
import hr.fer.objobl.shopking.viewmodel.RecipesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {

    single<NavigationManager> {
        NavigationManagerImpl()
    }

    single {
        ArticleDataSource()
    }

    single {
        CategoryDataSource()
    }

    single {
        RecipesDataSource()
    }

    single {
        RecipeDifficultiesDataSource()
    }

    viewModel {
        MainActivityViewModel(get())
    }

    viewModel {
        CatalogueViewModel(get(), get())
    }

    viewModel {
        RecipesViewModel(get(), get(), get())
    }

    viewModel {
        RecipeDetailsViewModel()
    }
}
