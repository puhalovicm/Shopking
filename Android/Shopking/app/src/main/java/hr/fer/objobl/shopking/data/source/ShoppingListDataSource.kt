package hr.fer.objobl.shopking.data.source

import androidx.lifecycle.MutableLiveData
import hr.fer.objobl.shopking.data.model.Article
import hr.fer.objobl.shopking.data.model.dao.ShopkingDatabase

class ShoppingListDataSource(
    private val database: ShopkingDatabase
) {

    val articles = database.shoppingListDao().getAll()

//    val articles: MutableLiveData<List<Article>> = MutableLiveData(
//        listOf(
//            Article(
//                1,
//                "Apples",
//                "K Plus",
//                "100 kn",
//                "https://post.healthline.com/wp-content/uploads/2020/09/Do_Apples_Affect_Diabetes_and_Blood_Sugar_Levels-732x549-thumbnail-1-732x549.jpg",
//                true
//            ),
//            Article(
//                2,
//                "Pears",
//                "Lidl",
//                "100 kn",
//                "https://goo.gl/gEgYUd",
//                true
//            ),
//            Article(
//                3,
//                "Blender",
//                "Sanja",
//                "300 kn",
//                "https://asda.scene7.com/is/image/Asda/5054781661290?hei=1800&wid=1800&qlt=85&fmt=pjpg&resmode=sharp&op_usm=1.1,0.5,0,0&defaultimage=default_details_George_rd",
//                true
//            ),
//            Article(
//                4,
//                "Banana",
//                "Banana",
//                "100 kn",
//                "data:image/jpeg;base64,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",
//                true
//            ),
//            Article(
//                5,
//                "Blender",
//                "Sanja",
//                "300 kn",
//                "https://asda.scene7.com/is/image/Asda/5054781661290?hei=1800&wid=1800&qlt=85&fmt=pjpg&resmode=sharp&op_usm=1.1,0.5,0,0&defaultimage=default_details_George_rd",
//                true
//            ),
//            Article(
//                6,
//                "Banana",
//                "Banana",
//                "100 kn",
//                "data:image/jpeg;base64,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",
//                true
//            ),
//            Article(
//                7,
//                "Blender",
//                "Sanja",
//                "300 kn",
//                "https://asda.scene7.com/is/image/Asda/5054781661290?hei=1800&wid=1800&qlt=85&fmt=pjpg&resmode=sharp&op_usm=1.1,0.5,0,0&defaultimage=default_details_George_rd",
//                true
//            ),
//            Article(
//                8,
//                "Banana",
//                "Banana",
//                "100 kn",
//                "data:image/jpeg;base64,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",
//                true
//            )
//        )
//    )
}
