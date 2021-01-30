package hr.fer.objobl.shopking.data.source

import androidx.lifecycle.MutableLiveData
import hr.fer.objobl.shopking.data.model.Shop

class ShopDataSource {

    val shops: MutableLiveData<List<Shop>> = MutableLiveData(
        listOf(
            Shop(1, "Unska ul. 33, 10000, Zagreb"),
            Shop(2, "Masarykova ul. 100, 10000, Zagreb")
        )
    )
}
