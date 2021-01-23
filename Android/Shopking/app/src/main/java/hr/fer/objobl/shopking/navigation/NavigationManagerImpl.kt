package hr.fer.objobl.shopking.navigation

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.view.CatalogueFragment

@IdRes
private const val MAIN_ACTIVITY_CONTAINER = R.id.main_activity_container

class NavigationManagerImpl(
    private val activity: AppCompatActivity
) : NavigationManager {

    override fun showCatalogueScreen() {
        val catalogueFragment = CatalogueFragment.newInstance()
        activity.supportFragmentManager
            .beginTransaction()
            .replace(MAIN_ACTIVITY_CONTAINER, catalogueFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun showShoppingListScreen() {
        // TODO("Not yet implemented")
    }

    override fun showWishListScreen() {
        //        TODO("Not yet implemented")
    }

    override fun showRecipesScreen() {
        //        TODO("Not yet implemented")
    }

    override fun showInformationScreen() {
        //        TODO("Not yet implemented")
    }
}
