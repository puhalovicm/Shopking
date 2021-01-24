package hr.fer.objobl.shopking.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.databinding.ActivityMainBinding
import hr.fer.objobl.shopking.data.model.ScreenType
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

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        setupOnNavigationItemSelectedListener()
        registerBottomNavigationObserver()
    }

    private fun setupOnNavigationItemSelectedListener() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_navigation_catalogue_item -> {
                    model.setScreenType(ScreenType.CATALOGUE)
                    true
                }
                R.id.bottom_navigation_shopping_list_item -> {
                    model.setScreenType(ScreenType.SHOPPING_LIST)
                    true
                }
                R.id.bottom_navigation_wish_list_item -> {
                    model.setScreenType(ScreenType.WISH_LIST)
                    true
                }
                R.id.bottom_navigation_recipes_item -> {
                    model.setScreenType(ScreenType.RECIPES)
                    true
                }
                R.id.bottom_navigation_information_item -> {
                    model.setScreenType(ScreenType.INFORMATION)
                    true
                }
                else -> false
            }
        }
    }

    private fun registerBottomNavigationObserver() {
        val screenTypeObserver = Observer<ScreenType> { type ->
            if (binding.bottomNavigation.selectedItemId != getScreenTypeId(type)) {
                binding.bottomNavigation.selectedItemId = getScreenTypeId(type)
            }

            model.showScreen(type)
        }

        model.screenType.observe(this, screenTypeObserver)
    }

    private fun getScreenTypeId(type: ScreenType) = when (type) {
        ScreenType.CATALOGUE -> R.id.bottom_navigation_catalogue_item
        ScreenType.SHOPPING_LIST -> R.id.bottom_navigation_shopping_list_item
        ScreenType.WISH_LIST -> R.id.bottom_navigation_wish_list_item
        ScreenType.RECIPES -> R.id.bottom_navigation_recipes_item
        ScreenType.INFORMATION -> R.id.bottom_navigation_information_item
    }
}
