package hr.fer.objobl.shopking.data.model.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface NotificationService {

    @POST("api/notifications")
    fun getNotifications(@Body ids: List<Long>): Call<List<Long>>
}
