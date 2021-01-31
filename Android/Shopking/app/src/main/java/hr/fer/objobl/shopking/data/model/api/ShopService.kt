package hr.fer.objobl.shopking.data.model.api

import retrofit2.Call
import retrofit2.http.GET

interface ShopService {

    @GET("api/shops")
    fun getShops(): Call<List<ApiShop>>
}
