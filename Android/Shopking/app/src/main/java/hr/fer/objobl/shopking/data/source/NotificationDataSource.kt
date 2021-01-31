package hr.fer.objobl.shopking.data.source

import androidx.lifecycle.MutableLiveData
import hr.fer.objobl.shopking.data.mapper.mapToShopList
import hr.fer.objobl.shopking.data.model.Notification
import hr.fer.objobl.shopking.data.model.Shop
import hr.fer.objobl.shopking.data.model.api.ApiShop
import hr.fer.objobl.shopking.data.model.api.NotificationService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotificationDataSource(
    private val notificationService: NotificationService
) {

    val notifications: MutableLiveData<List<Notification>> = MutableLiveData()

    fun fetchNotifications(ids: List<Long>) {
        notificationService.getNotifications(ids).enqueue(object : Callback<List<Long>> {

            override fun onResponse(call: Call<List<Long>>, response: Response<List<Long>>) {
                if (response.isSuccessful) {
                    notifications.postValue(response.body()?.map { Notification(it) })
                }
            }

            override fun onFailure(call: Call<List<Long>>, t: Throwable) {}
        })
    }
}
