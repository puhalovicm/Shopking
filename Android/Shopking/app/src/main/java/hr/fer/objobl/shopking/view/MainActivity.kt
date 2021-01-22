package hr.fer.objobl.shopking.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_navigation_catalogoue_item -> true
                R.id.bottom_navigation_shopping_list_item -> true
                R.id.bottom_navigation_wish_list_item -> true
                R.id.bottom_navigation_recipes_item -> true
                R.id.bottom_navigation_information_item -> true
                else -> false
            }
        }
    }
}
