package hr.fer.objobl.shopking.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.fer.objobl.shopking.data.source.ArticleDataSource
import hr.fer.objobl.shopking.data.source.NotificationDataSource
import hr.fer.objobl.shopking.data.source.WishListDataSource
import hr.fer.objobl.shopking.utils.ShopkingStrings
import hr.fer.objobl.shopking.view.viewstate.NotificationViewState

class NotificationsViewModel(
    private val notificationDataSource: NotificationDataSource,
    private val articleDataSource: ArticleDataSource,
    private val wishListDataSource: WishListDataSource,
    private val shopkingStrings: ShopkingStrings
) : ViewModel() {

    val notifications: MutableLiveData<List<NotificationViewState>> by lazy { MutableLiveData() }

    init {
        notificationDataSource.notifications.observeForever {
            notifications.postValue(
                it.map { notification ->
                    NotificationViewState(
                        shopkingStrings.notificationContent()
                            .format(articleDataSource.articles.value!!.first { it.id == notification.articleId }.name)
                    )
                })
        }

        wishListDataSource.articles.value?.let {
            fetchNotifications(it.map { it.id })
        }
    }

    private fun fetchNotifications(ids: List<Long>) {
        notificationDataSource.fetchNotifications(ids)
    }
}
