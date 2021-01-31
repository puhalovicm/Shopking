package hr.fer.objobl.shopking.data.source

import androidx.lifecycle.MutableLiveData
import hr.fer.objobl.shopking.data.model.Recipe

class RecipesDataSource {

    val recipes: MutableLiveData<List<Recipe>> = MutableLiveData(
        listOf(
            Recipe(
                1,
                "Apple pie",
                "In a small bowl, combine the sugars, flour and spices; set aside. In a large bowl, toss apples with lemon juice. Add sugar mixture….",
                "https://post.healthline.com/wp-content/uploads/2020/09/Do_Apples_Affect_Diabetes_and_Blood_Sugar_Levels-732x549-thumbnail-1-732x549.jpg",
                listOf("Apple", "Honey", "Sugar"),
                20,
                "125 kn",
                "EASY"
            ),
            Recipe(
                2,
                "Salmon",
                "Bake salmon",
                "https://post.healthline.com/wp-content/uploads/2020/09/Do_Apples_Affect_Diabetes_and_Blood_Sugar_Levels-732x549-thumbnail-1-732x549.jpg",
                listOf("Salmon", "Salt", "Wine"),
                20,
                "68 kn",
                "MEDIUM"
            )
        )
    )
}
