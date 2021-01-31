package hr.fer.objobl.shopking.viewmodel

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.fer.objobl.shopking.data.mapper.mapToViewStateList
import hr.fer.objobl.shopking.data.source.ShopDataSource
import hr.fer.objobl.shopking.navigation.NavigationManager
import hr.fer.objobl.shopking.view.viewstate.ShopViewState

class ShopsViewModel(
    private val shopDataSource: ShopDataSource,
    private val navigationManager: NavigationManager
) : ViewModel() {

    val shops: MutableLiveData<List<ShopViewState>> by lazy { MutableLiveData(shopDataSource.shops.value?.mapToViewStateList()) }

    init {
        shopDataSource.shops.observeForever {
            shops.postValue(it.mapToViewStateList())
        }
    }

    fun showShopOnMap(activity: AppCompatActivity, address: String) {
        navigationManager.showShopOnMap(activity, address)
    }
}
