package hr.fer.objobl.shopking.data.mapper

import hr.fer.objobl.shopking.data.model.Recipe
import hr.fer.objobl.shopking.data.model.api.ApiRecipe
import hr.fer.objobl.shopking.view.viewstate.RecipeDetailsViewState
import hr.fer.objobl.shopking.view.viewstate.RecipeViewState

fun List<Recipe>.mapToViewStateList() = this.map { it.mapToViewState() }

private fun Recipe.mapToViewState() = RecipeViewState(
    id,
    name,
    imageUrl,
    timeEstimated,
    totalPrice,
    difficulty
)

fun Recipe.mapToDetailsViewState() = RecipeDetailsViewState(
    id,
    name,
    imageUrl,
    description,
    ingredients,
    timeEstimated,
    totalPrice,
    difficulty
)

fun List<ApiRecipe>.mapToRecipeList() = map { it.mapToRecipe() }

fun ApiRecipe.mapToRecipe() = Recipe(
    id,
    name,
    description,
    "https://post.healthline.com/wp-content/uploads/2020/09/Do_Apples_Affect_Diabetes_and_Blood_Sugar_Levels-732x549-thumbnail-1-732x549.jpg",
    ingredients,
    estimatedTime,
    "10",
    difficulty
)
