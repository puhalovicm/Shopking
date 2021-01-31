package hr.fer.objobl.shopking.data.source

import androidx.lifecycle.MutableLiveData

class CategoryDataSource {

    val categories: MutableLiveData<List<String>> = MutableLiveData(
        listOf(
            "All",
            "Food",
            "Beverage",
            "Tech"
        )
    )
}
