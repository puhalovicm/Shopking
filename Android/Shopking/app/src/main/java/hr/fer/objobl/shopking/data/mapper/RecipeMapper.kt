package hr.fer.objobl.shopking.data.mapper

import hr.fer.objobl.shopking.data.model.Recipe
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

