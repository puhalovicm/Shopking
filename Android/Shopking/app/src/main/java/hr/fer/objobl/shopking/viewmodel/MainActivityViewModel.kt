package hr.fer.objobl.shopking.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.fer.objobl.shopking.common.DistinctUntilChangedMutableLiveData
import hr.fer.objobl.shopking.model.ScreenType
import hr.fer.objobl.shopking.navigation.NavigationManager

class MainActivityViewModel(
    private val navigationManager: NavigationManager
) : ViewModel() {

    val screenType: MutableLiveData<ScreenType> by lazy { DistinctUntilChangedMutableLiveData(ScreenType.CATALOGUE) }

    fun setScreenType(type: ScreenType) {
        screenType.value = type
    }

    fun showScreen(type: ScreenType) = when (type) {
        ScreenType.CATALOGUE -> showCatalogueScreen()
        ScreenType.SHOPPING_LIST -> showShoppingListScreen()
        ScreenType.WISH_LIST -> showWishListScreen()
        ScreenType.RECIPES -> showRecipesScreen()
        ScreenType.INFORMATION -> showInformationScreen()
    }

    private fun showCatalogueScreen() {
        navigationManager.showCatalogueScreen()
    }

    private fun showShoppingListScreen() {
        navigationManager.showShoppingListScreen()
    }

    private fun showWishListScreen() {
        navigationManager.showWishListScreen()
    }

    private fun showRecipesScreen() {
        navigationManager.showRecipesScreen()
    }

    private fun showInformationScreen() {
        navigationManager.showInformationScreen()
    }
}
