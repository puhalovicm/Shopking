package hr.fer.objobl.shopking.data.source

import androidx.lifecycle.MutableLiveData
import hr.fer.objobl.shopking.data.model.Category

class CategoryDataSource {

    val categories: MutableLiveData<List<Category>> = MutableLiveData(
        listOf(
            Category(
                1,
                "All"
            ),
            Category(
                2,
                "Food"
            ),
            Category(
                3,
                "Beverage"
            ),
            Category(
                4,
                "Tech"
            ),
        )
    )
}
