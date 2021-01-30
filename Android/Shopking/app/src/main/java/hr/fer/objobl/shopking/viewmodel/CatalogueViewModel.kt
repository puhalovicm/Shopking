package hr.fer.objobl.shopking.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.fer.objobl.shopking.data.mapper.mapToCategoryViewStateList
import hr.fer.objobl.shopking.data.mapper.mapToViewStateList
import hr.fer.objobl.shopking.data.source.ArticleDataSource
import hr.fer.objobl.shopking.data.source.CategoryDataSource
import hr.fer.objobl.shopking.view.viewstate.ArticleViewState
import hr.fer.objobl.shopking.view.viewstate.CategoryViewState

class CatalogueViewModel(
    private val articleDataSource: ArticleDataSource,
    private val categoryDataSource: CategoryDataSource,
) : ViewModel() {

    val articles: MutableLiveData<List<ArticleViewState>> by lazy { MutableLiveData(articleDataSource.articles.value?.mapToViewStateList()) }

    val categories: MutableLiveData<List<CategoryViewState>> by lazy {
        MutableLiveData(
            categoryDataSource.categories.value?.mapToCategoryViewStateList()?.mapIndexed { index, categoryViewState ->
                if (index == 0) {
                    categoryViewState.isSelected = true
                }

                categoryViewState
            }
        )
    }

    init {
        articleDataSource.articles.observeForever {
            articles.postValue(it.mapToViewStateList())
        }
    }

    fun fetchArticles() {
        articles.value = articles.value!!
    }

    fun selectCategory(category: String) {
        categories.value = categories.value?.map { CategoryViewState(it.name, it.name == category) }
    }
}
