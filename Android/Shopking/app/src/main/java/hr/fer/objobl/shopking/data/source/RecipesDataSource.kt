package hr.fer.objobl.shopking.data.source

import androidx.lifecycle.MutableLiveData
import hr.fer.objobl.shopking.data.mapper.mapToRecipeList
import hr.fer.objobl.shopking.data.model.Recipe
import hr.fer.objobl.shopking.data.model.api.ApiRecipe
import hr.fer.objobl.shopking.data.model.api.RecipeService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipesDataSource(
    private val recipeService: RecipeService
) {

    val recipes = MutableLiveData<List<Recipe>>()

    fun fetchRecipes() {
        recipeService.getRecipes().enqueue(object : Callback<List<ApiRecipe>> {

            override fun onResponse(call: Call<List<ApiRecipe>>, response: Response<List<ApiRecipe>>) {
                if (response.isSuccessful) {
                    recipes.postValue(response.body()?.mapToRecipeList())
                }
            }

            override fun onFailure(call: Call<List<ApiRecipe>>, t: Throwable) {}
        })
    }

    fun fetchRecipesByDifficulty(difficulty: String) {
        recipeService.getRecipesByDifficulty(difficulty).enqueue(object : Callback<List<ApiRecipe>> {

            override fun onResponse(call: Call<List<ApiRecipe>>, response: Response<List<ApiRecipe>>) {
                if (response.isSuccessful) {
                    recipes.postValue(response.body()?.mapToRecipeList())
                }
            }

            override fun onFailure(call: Call<List<ApiRecipe>>, t: Throwable) {}
        })
    }
}
