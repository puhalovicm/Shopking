package hr.fer.objobl.shopking.data.mapper

import hr.fer.objobl.shopking.data.model.Category
import hr.fer.objobl.shopking.view.viewstate.CategoryViewState

fun List<Category>.mapToViewStateList() = this.map { it.mapToViewState() }

private fun Category.mapToViewState() = CategoryViewState(
    id,
    name,
    false
)
