package hr.fer.objobl.shopking.data.mapper

import hr.fer.objobl.shopking.view.viewstate.CategoryViewState

fun List<String>.mapToCategoryViewStateList() = this.map { it.mapToCategoryViewState() }

private fun String.mapToCategoryViewState() = CategoryViewState(
    this,
    false
)
