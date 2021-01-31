package hr.fer.objobl.shopking.data.mapper

import hr.fer.objobl.shopking.view.viewstate.RecipeDifficultyViewState

fun List<String>.mapToRecipeDifficultyViewStateList() = this.map { it.mapToRecipeDifficultyViewState() }

private fun String.mapToRecipeDifficultyViewState() = RecipeDifficultyViewState(
    this,
    false
)
