package hr.fer.objobl.shopking.navigation

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.view.CatalogueFragment
import hr.fer.objobl.shopking.view.RecipeDetailsFragment
import hr.fer.objobl.shopking.view.RecipesFragment
import hr.fer.objobl.shopking.view.viewstate.RecipeDetailsViewState

@IdRes
private const val MAIN_ACTIVITY_CONTAINER = R.id.main_activity_container

class NavigationManagerImpl : NavigationManager {

    override fun showCatalogueScreen(activity: AppCompatActivity) {
        val catalogueFragment = CatalogueFragment.newInstance()
        activity.supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
            .replace(MAIN_ACTIVITY_CONTAINER, catalogueFragment)
            .commit()
    }

    override fun showShoppingListScreen(activity: AppCompatActivity) {
        // TODO("Not yet implemented")
    }

    override fun showWishListScreen(activity: AppCompatActivity) {
        //        TODO("Not yet implemented")
    }

    override fun showRecipesScreen(activity: AppCompatActivity) {
        val recipesFragment = RecipesFragment.newInstance()
        activity.supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
            .replace(MAIN_ACTIVITY_CONTAINER, recipesFragment)
            .commit()
    }

    override fun showRecipeDetails(activity: AppCompatActivity, recipeDetailsViewState: RecipeDetailsViewState) {
        val recipeDetailsFragment = RecipeDetailsFragment.newInstance(recipeDetailsViewState)
        activity.supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right,
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right
            )
            .add(MAIN_ACTIVITY_CONTAINER, recipeDetailsFragment)
            .addToBackStack(RecipeDetailsFragment.TAG)
            .commit()
    }

    override fun showInformationScreen(activity: AppCompatActivity) {
        //        TODO("Not yet implemented")
    }

    override fun goBack(activity: AppCompatActivity) {
        if (activity.supportFragmentManager.backStackEntryCount != 0) {
            activity.supportFragmentManager.popBackStackImmediate()
        } else {
            activity.finish()
        }
    }
}
