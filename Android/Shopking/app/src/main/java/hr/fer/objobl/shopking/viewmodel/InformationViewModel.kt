package hr.fer.objobl.shopking.viewmodel

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.fer.objobl.shopking.data.mapper.mapToViewStateList
import hr.fer.objobl.shopking.data.source.ArticleDataSource
import hr.fer.objobl.shopking.data.source.NotificationDataSource
import hr.fer.objobl.shopking.data.source.ShopDataSource
import hr.fer.objobl.shopking.navigation.NavigationManager
import hr.fer.objobl.shopking.utils.ShopkingStrings
import hr.fer.objobl.shopking.view.viewstate.NotificationViewState
import hr.fer.objobl.shopking.view.viewstate.ShopViewState

class InformationViewModel(
    private val notificationDataSource: NotificationDataSource,
    private val shopDataSource: ShopDataSource,
    private val articleDataSource: ArticleDataSource,
    private val navigationManager: NavigationManager,
    private val shopkingStrings: ShopkingStrings
) : ViewModel() {

    val notifications: MutableLiveData<List<NotificationViewState>> by lazy { MutableLiveData() }
    val shops: MutableLiveData<List<ShopViewState>> by lazy { MutableLiveData(shopDataSource.shops.value?.mapToViewStateList()) }

    init {
        notificationDataSource.notifications.observeForever {
            notifications.postValue(
                it.map { notification ->
                    NotificationViewState(
                        shopkingStrings.notificationContent().format(articleDataSource.articles.value!!.first { it.id == notification.articleId }.name)
                    )
                })
        }

        shopDataSource.shops.observeForever {
            shops.postValue(it.mapToViewStateList())
        }
    }

    fun showNotificationsScreen(activity: AppCompatActivity) {
        navigationManager.showNotificationsScreen(activity)
    }

    fun showShopsScreen(activity: AppCompatActivity) {
        navigationManager.showShopsScreen(activity)
    }

    fun showShopOnMap(activity: AppCompatActivity, address: String) {
        navigationManager.showShopOnMap(activity, address)
    }
}
