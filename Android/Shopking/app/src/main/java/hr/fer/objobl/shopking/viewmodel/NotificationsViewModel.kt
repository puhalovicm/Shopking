package hr.fer.objobl.shopking.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.fer.objobl.shopking.data.source.ArticleDataSource
import hr.fer.objobl.shopking.data.source.NotificationDataSource
import hr.fer.objobl.shopking.utils.ShopkingStrings
import hr.fer.objobl.shopking.view.viewstate.NotificationViewState

class NotificationsViewModel(
    private val notificationDataSource: NotificationDataSource,
    private val articleDataSource: ArticleDataSource,
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
    }
}
