package hr.fer.objobl.shopking.data.model.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeService {

    @GET("api/recipes")
    fun getRecipes(): Call<List<ApiRecipe>>

    @GET("api/recipes")
    fun getRecipesByDifficulty(@Query("difficulty") difficulty: String): Call<List<ApiRecipe>>

    @GET("api/recipes/{id}")
    fun getRecipesById(@Path("id") id: Long): Call<ApiRecipe>
}
