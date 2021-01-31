package hr.fer.objobl.shopking.data.source

import androidx.lifecycle.MutableLiveData
import hr.fer.objobl.shopking.data.model.Notification

class NotificationDataSource {

    val notifications: MutableLiveData<List<Notification>> = MutableLiveData(
        listOf(
            Notification(1),
            Notification(2)
        )
    )
}
