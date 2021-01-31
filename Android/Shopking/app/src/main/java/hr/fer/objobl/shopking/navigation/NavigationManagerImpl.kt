package hr.fer.objobl.shopking.navigation

import android.content.Intent
import android.net.Uri
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.view.*
import hr.fer.objobl.shopking.view.viewstate.ArticleDetailsViewState
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

    override fun showArticleDetails(activity: AppCompatActivity, viewState: ArticleDetailsViewState) {
        ArticleDetailsSheetFragment.newInstance(viewState).apply {
            show(activity.supportFragmentManager, ArticleDetailsSheetFragment.TAG)
        }
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
        val informationFragment = InformationFragment.newInstance()
        activity.supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
            .replace(MAIN_ACTIVITY_CONTAINER, informationFragment)
            .commit()
    }

    override fun showNotificationsScreen(activity: AppCompatActivity) {
        val notificationsFragment = NotificationsFragment.newInstance()
        activity.supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right,
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right
            )
            .add(MAIN_ACTIVITY_CONTAINER, notificationsFragment)
            .addToBackStack(RecipeDetailsFragment.TAG)
            .commit()
    }

    override fun showShopsScreen(activity: AppCompatActivity) {
        val shopsFragment = ShopsFragment.newInstance()
        activity.supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right,
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right
            )
            .add(MAIN_ACTIVITY_CONTAINER, shopsFragment)
            .addToBackStack(RecipeDetailsFragment.TAG)
            .commit()
    }

    override fun showShopOnMap(activity: AppCompatActivity, address: String) {
        //        val gmmIntentUri = Uri.parse("geo:0,0?q=1600 Amphitheatre Parkway, Mountain+View, California")
        val gmmIntentUri = Uri.parse("geo:0,0?q=$address")

        //        val gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(activity, mapIntent, null)
    }

    override fun goBack(activity: AppCompatActivity) {
        if (activity.supportFragmentManager.backStackEntryCount != 0) {
            activity.supportFragmentManager.popBackStackImmediate()
        } else {
            activity.finish()
        }
    }
}
