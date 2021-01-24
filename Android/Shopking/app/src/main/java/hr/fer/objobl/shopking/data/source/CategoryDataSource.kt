package hr.fer.objobl.shopking.data.source

import androidx.lifecycle.MutableLiveData
import hr.fer.objobl.shopking.data.model.Category

class CategoryDataSource {

    val categories: MutableLiveData<List<Category>> = MutableLiveData(
        listOf(
            Category(
                1,
                "Food"
            ),
            Category(
                2,
                "Beverage"
            ),
            Category(
                3,
                "Tech"
            ),
        )
    )
}
