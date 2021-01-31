package hr.fer.objobl.shopking.data.mapper

import hr.fer.objobl.shopking.view.viewstate.IngredientViewState

fun List<String>.mapToIngredientViewStateList() = this.map { it.mapToIngredientViewState() }

private fun String.mapToIngredientViewState() = IngredientViewState(
    this,
    false,
    false
)
