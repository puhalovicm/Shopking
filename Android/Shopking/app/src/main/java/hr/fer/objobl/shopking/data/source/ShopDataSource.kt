package hr.fer.objobl.shopking.data.source

import androidx.lifecycle.MutableLiveData
import hr.fer.objobl.shopking.data.mapper.mapToShopList
import hr.fer.objobl.shopking.data.model.Shop
import hr.fer.objobl.shopking.data.model.api.ApiShop
import hr.fer.objobl.shopking.data.model.api.ShopService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShopDataSource(
    private val shopService: ShopService
) {

    val shops: MutableLiveData<List<Shop>> = MutableLiveData()

    fun fetchShops() {
        shopService.getShops().enqueue(object : Callback<List<ApiShop>> {

            override fun onResponse(call: Call<List<ApiShop>>, response: Response<List<ApiShop>>) {
                if (response.isSuccessful) {
                    shops.postValue(response.body()?.mapToShopList())
                }
            }

            override fun onFailure(call: Call<List<ApiShop>>, t: Throwable) {}
        })
    }
}
