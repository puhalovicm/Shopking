package hr.fer.objobl.shopking.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.fer.objobl.shopking.model.ScreenType
import hr.fer.objobl.shopking.navigation.NavigationManager

class MainActivityViewModel(
    private val navigationManager: NavigationManager
) : ViewModel() {

    val screenType: MutableLiveData<ScreenType> by lazy { MutableLiveData(ScreenType.CATALOGOUE) }

    fun showCatalogoueScreen() {
        screenType.value = ScreenType.CATALOGOUE
        navigationManager.showCatalogoueScreen()
    }

    fun showShoppingListScreen() {
        screenType.value = ScreenType.SHOPPING_LIST
        navigationManager.showShoppingListScreen()
    }

    fun showWishListScreen() {
        screenType.value = ScreenType.WISH_LIST
        navigationManager.showWishListScreen()
    }

    fun showRecipesScreen() {
        screenType.value = ScreenType.RECIPES
        navigationManager.showRecipesScreen()
    }

    fun showInformationScreen() {
        screenType.value = ScreenType.INFORMATION
        navigationManager.showInformationScreen()
    }
}
