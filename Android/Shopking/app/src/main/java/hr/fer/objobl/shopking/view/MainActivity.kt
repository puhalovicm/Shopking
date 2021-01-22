package hr.fer.objobl.shopking.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.databinding.ActivityMainBinding
import hr.fer.objobl.shopking.navigation.NavigationManager
import hr.fer.objobl.shopking.viewmodel.MainActivityViewModel
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val navigationManager: NavigationManager by inject(parameters = { parametersOf(this) })
    private val model: MainActivityViewModel by inject(parameters = { parametersOf(navigationManager) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_navigation_catalogoue_item -> {
                    model.showCatalogoueScreen()
                    true
                }
                R.id.bottom_navigation_shopping_list_item -> {
                    model.showShoppingListScreen()
                    true
                }
                R.id.bottom_navigation_wish_list_item -> {
                    model.showWishListScreen()
                    true
                }
                R.id.bottom_navigation_recipes_item -> {
                    model.showRecipesScreen()
                    true
                }
                R.id.bottom_navigation_information_item -> {
                    model.showInformationScreen()
                    true
                }
                else -> false
            }
        }
    }
}
