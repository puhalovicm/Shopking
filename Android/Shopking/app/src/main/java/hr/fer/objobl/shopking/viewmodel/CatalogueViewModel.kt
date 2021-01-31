package hr.fer.objobl.shopking.viewmodel

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.fer.objobl.shopking.data.mapper.mapToCategoryViewStateList
import hr.fer.objobl.shopking.data.mapper.mapToDetailsViewState
import hr.fer.objobl.shopking.data.mapper.mapToViewStateList
import hr.fer.objobl.shopking.data.source.ArticleDataSource
import hr.fer.objobl.shopking.data.source.CategoryDataSource
import hr.fer.objobl.shopking.data.source.ShoppingListDataSource
import hr.fer.objobl.shopking.data.source.WishListDataSource
import hr.fer.objobl.shopking.navigation.NavigationManager
import hr.fer.objobl.shopking.view.viewstate.ArticleViewState
import hr.fer.objobl.shopking.view.viewstate.CategoryViewState

class CatalogueViewModel(
    private val articleDataSource: ArticleDataSource,
    private val categoryDataSource: CategoryDataSource,
    private val shoppingListDataSource: ShoppingListDataSource,
    private val wishListDataSource: WishListDataSource,
    private val navigationManager: NavigationManager
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

        categoryDataSource.categories.observeForever {
            categories.postValue(it.mapToCategoryViewStateList())
        }

        fetchItems()
        fetchCategories()
    }

    private fun fetchCategories() {
        categoryDataSource.fetchCategories()
    }

    private fun fetchItems() {
        articleDataSource.fetchItems()
    }

    fun fetchArticles() {
        articles.value = articles.value!!
    }

    fun selectCategory(category: String) {
        categories.value = categories.value?.map { CategoryViewState(it.name, it.name == category) }
        articleDataSource.fetchItems(category)
    }

    fun showArticleDetails(activity: AppCompatActivity, id: Long) {
        articleDataSource.articles.value?.first { it.id == id }?.let {
            navigationManager.showArticleDetails(activity, it.mapToDetailsViewState())
        }
    }

    fun addToWishList(id: Long) {
        articleDataSource.fetchItemForWishList(id, onResponseAction = {
            wishListDataSource.addItem(it)
        })
    }

    fun addToShoppingList(id: Long) {
        articleDataSource.fetchItemForShoppingList(id, onResponseAction = {
            shoppingListDataSource.addItem(it)
        })
    }
}
