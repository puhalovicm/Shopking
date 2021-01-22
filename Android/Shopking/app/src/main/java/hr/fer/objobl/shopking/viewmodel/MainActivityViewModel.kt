package hr.fer.objobl.shopking.viewmodel

import androidx.lifecycle.ViewModel
import hr.fer.objobl.shopking.navigation.NavigationManager

class MainActivityViewModel(
    private val navigationManager: NavigationManager
) : ViewModel() {

    fun showCatalogoueScreen() {
        navigationManager.showCatalogoueScreen()
    }

    fun showShoppingListScreen() {
        navigationManager.showShoppingListScreen()
    }

    fun showWishListScreen() {
        navigationManager.showWishListScreen()
    }

    fun showRecipesScreen() {
        navigationManager.showRecipesScreen()
    }

    fun showInformationScreen() {
        navigationManager.showInformationScreen()
    }
}
