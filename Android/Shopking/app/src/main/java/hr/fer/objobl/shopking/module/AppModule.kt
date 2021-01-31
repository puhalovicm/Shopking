package hr.fer.objobl.shopking.module

import androidx.room.Room
import hr.fer.objobl.shopking.data.api.ApiClient
import hr.fer.objobl.shopking.data.db.ShopkingDatabase
import hr.fer.objobl.shopking.data.model.api.ItemsService
import hr.fer.objobl.shopking.data.model.api.NotificationService
import hr.fer.objobl.shopking.data.model.api.RecipeService
import hr.fer.objobl.shopking.data.model.api.ShopService
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

    single<ShopkingDatabase> {
        Room.databaseBuilder(
            get(),
            ShopkingDatabase::class.java, "shopking_db"
        ).allowMainThreadQueries().build()
    }

    single<RecipeService> {
        ApiClient.retrofit.create(RecipeService::class.java)
    }

    single<ShopService> {
        ApiClient.retrofit.create(ShopService::class.java)
    }

    single<ItemsService> {
        ApiClient.retrofit.create(ItemsService::class.java)
    }

    single<NotificationService> {
        ApiClient.retrofit.create(NotificationService::class.java)
    }

    single<NavigationManager> {
        NavigationManagerImpl()
    }

    single {
        ArticleDataSource(get())
    }

    single {
        CategoryDataSource(get())
    }

    single {
        RecipesDataSource(get())
    }

    single {
        NotificationDataSource(get())
    }

    single {
        ShopDataSource(get())
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
        CatalogueViewModel(get(), get(), get(), get(), get())
    }

    viewModel {
        RecipesViewModel(get(), get(), get())
    }

    viewModel {
        RecipeDetailsViewModel()
    }

    viewModel {
        NotificationsViewModel(get(), get(), get(), get())
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
        InformationViewModel(get(), get(), get(), get(), get(), get())
    }
}
