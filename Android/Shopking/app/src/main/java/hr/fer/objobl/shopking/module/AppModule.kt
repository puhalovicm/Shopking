package hr.fer.objobl.shopking.module

import androidx.room.Room
import hr.fer.objobl.shopking.data.model.dao.ShopkingDatabase
import hr.fer.objobl.shopking.data.source.*
import hr.fer.objobl.shopking.navigation.NavigationManager
import hr.fer.objobl.shopking.navigation.NavigationManagerImpl
import hr.fer.objobl.shopking.utils.ShopkingStrings
import hr.fer.objobl.shopking.utils.ShopkingStringsImpl
import hr.fer.objobl.shopking.viewmodel.*
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {

    single<ShopkingDatabase> {
        Room.databaseBuilder(
            get(),
            ShopkingDatabase::class.java, "shopking_db"
        ).build()
    }

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
        ShoppingListDataSource(get())
    }

    single {
        WishListDataSource(get())
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
        ShoppingListViewModel(get(), get())
    }

    viewModel {
        WishListViewModel(get(), get())
    }

    viewModel {
        InformationViewModel(get(), get(), get(), get(), get())
    }
}
