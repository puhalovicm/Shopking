package hr.fer.objobl.shopking.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.fer.objobl.shopking.data.mapper.mapToWishListViewStateList
import hr.fer.objobl.shopking.data.source.WishListDataSource
import hr.fer.objobl.shopking.navigation.NavigationManager
import hr.fer.objobl.shopking.view.viewstate.ArticleWishListViewState

class WishListViewModel(
    private val articleDataSource: WishListDataSource,
    private val navigationManager: NavigationManager
) : ViewModel() {

    val articles: MutableLiveData<List<ArticleWishListViewState>> by lazy { MutableLiveData(articleDataSource.articles.value?.mapToWishListViewStateList()) }

    init {
        articleDataSource.articles.observeForever {
            articles.postValue(it.mapToWishListViewStateList())
        }
    }

    fun fetchArticles() {
        articles.value = articles.value!!
    }
}
