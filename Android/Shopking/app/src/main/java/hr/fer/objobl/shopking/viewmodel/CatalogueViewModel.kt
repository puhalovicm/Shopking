package hr.fer.objobl.shopking.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.fer.objobl.shopking.data.mapper.mapToViewStateList
import hr.fer.objobl.shopking.data.source.ArticleDataSource
import hr.fer.objobl.shopking.view.viewstate.ArticleViewState

class CatalogueViewModel(
    private val articleDataSource: ArticleDataSource
) : ViewModel() {

    val articles: MutableLiveData<List<ArticleViewState>> by lazy { MutableLiveData(articleDataSource.articles.value?.mapToViewStateList()) }
}
