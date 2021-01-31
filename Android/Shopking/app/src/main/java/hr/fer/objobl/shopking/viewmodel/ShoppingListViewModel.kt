package hr.fer.objobl.shopking.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.fer.objobl.shopking.data.mapper.mapToShoppingListViewStateList
import hr.fer.objobl.shopking.data.source.ShoppingListDataSource
import hr.fer.objobl.shopking.navigation.NavigationManager
import hr.fer.objobl.shopking.view.viewstate.ArticleShoppingListViewState

class ShoppingListViewModel(
    private val articleDataSource: ShoppingListDataSource,
    private val navigationManager: NavigationManager
) : ViewModel() {

    val articles: MutableLiveData<List<ArticleShoppingListViewState>> by lazy { MutableLiveData(articleDataSource.articles.value?.mapToShoppingListViewStateList()) }

    init {
        articleDataSource.articles.observeForever {
            articles.postValue(it.mapToShoppingListViewStateList())
        }
    }

    fun fetchArticles() {
        articles.value = articles.value!!
    }
}
