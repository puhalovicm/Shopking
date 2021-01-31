package hr.fer.objobl.shopking.module

import hr.fer.objobl.shopking.data.source.*
import hr.fer.objobl.shopking.navigation.NavigationManager
import hr.fer.objobl.shopking.navigation.NavigationManagerImpl
import hr.fer.objobl.shopking.utils.ShopkingStrings
import hr.fer.objobl.shopking.utils.ShopkingStringsImpl
import hr.fer.objobl.shopking.viewmodel.*
import org.koin.android.ext.koin.androidContext
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
        NotificationDataSource()
    }

    single {
        ShopDataSource()
    }

    single {
        RecipeDifficultiesDataSource()
    }

    single<ShopkingStrings> {
        ShopkingStringsImpl(androidContext().resources)
    }

    viewModel {
        MainActivityViewModel(get())
    }

    viewModel {
        CatalogueViewModel(get(), get(), get())
    }

    viewModel {
        RecipesViewModel(get(), get(), get())
    }

    viewModel {
        RecipeDetailsViewModel()
    }

    viewModel {
        NotificationsViewModel(get(), get(), get())
    }

    viewModel {
        ShopsViewModel(get(), get())
    }

    viewModel {
        InformationViewModel(get(), get(), get(), get(), get())
    }
}
