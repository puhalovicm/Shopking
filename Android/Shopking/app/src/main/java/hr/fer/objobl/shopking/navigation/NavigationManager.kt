package hr.fer.objobl.shopking.navigation

import androidx.appcompat.app.AppCompatActivity
import hr.fer.objobl.shopking.view.viewstate.ArticleDetailsViewState
import hr.fer.objobl.shopking.view.viewstate.RecipeDetailsViewState

interface NavigationManager {

    fun showCatalogueScreen(activity: AppCompatActivity)

    fun showArticleDetails(activity: AppCompatActivity, viewState: ArticleDetailsViewState)

    fun showShoppingListScreen(activity: AppCompatActivity)

    fun showWishListScreen(activity: AppCompatActivity)

    fun showRecipesScreen(activity: AppCompatActivity)

    fun showRecipeDetails(activity: AppCompatActivity, recipeDetailsViewState: RecipeDetailsViewState)

    fun showInformationScreen(activity: AppCompatActivity)

    fun showNotificationsScreen(activity: AppCompatActivity)

    fun showShopsScreen(activity: AppCompatActivity)

    fun showShopOnMap(activity: AppCompatActivity, address: String)

    fun goBack(activity: AppCompatActivity)
}
