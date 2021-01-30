package hr.fer.objobl.shopking.viewmodel

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.fer.objobl.shopking.data.model.ScreenType
import hr.fer.objobl.shopking.navigation.NavigationManager

class MainActivityViewModel(
    private val navigationManager: NavigationManager
) : ViewModel() {

    val screenType: MutableLiveData<ScreenType> by lazy { MutableLiveData(ScreenType.CATALOGUE) }

    fun setScreenType(type: ScreenType) {
        screenType.value = type
    }

    fun showScreen(activity: AppCompatActivity, type: ScreenType) = when (type) {
        ScreenType.CATALOGUE -> showCatalogueScreen(activity)
        ScreenType.SHOPPING_LIST -> showShoppingListScreen(activity)
        ScreenType.WISH_LIST -> showWishListScreen(activity)
        ScreenType.RECIPES -> showRecipesScreen(activity)
        ScreenType.INFORMATION -> showInformationScreen(activity)
    }

    private fun showCatalogueScreen(activity: AppCompatActivity) {
        navigationManager.showCatalogueScreen(activity)
    }

    private fun showShoppingListScreen(activity: AppCompatActivity) {
        navigationManager.showShoppingListScreen(activity)
    }

    private fun showWishListScreen(activity: AppCompatActivity) {
        navigationManager.showWishListScreen(activity)
    }

    private fun showRecipesScreen(activity: AppCompatActivity) {
        navigationManager.showRecipesScreen(activity)
    }

    private fun showInformationScreen(activity: AppCompatActivity) {
        navigationManager.showInformationScreen(activity)
    }

    fun goBack(activity: AppCompatActivity) {
        navigationManager.goBack(activity)
    }
}
