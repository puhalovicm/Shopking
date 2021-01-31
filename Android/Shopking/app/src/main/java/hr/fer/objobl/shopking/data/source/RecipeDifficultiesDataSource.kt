package hr.fer.objobl.shopking.data.source

import androidx.lifecycle.MutableLiveData

class RecipeDifficultiesDataSource {

    val difficulties: MutableLiveData<List<String>> = MutableLiveData(
        listOf(
            "All",
            "Easy",
            "Medium",
            "Difficult"
        )
    )
}
