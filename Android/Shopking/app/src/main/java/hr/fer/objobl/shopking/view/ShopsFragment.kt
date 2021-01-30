package hr.fer.objobl.shopking.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.databinding.FragmentShopsBinding
import hr.fer.objobl.shopking.view.adapter.ShopListAdapter
import hr.fer.objobl.shopking.view.adapter.decoration.NonFirstItemOffsetDecoration
import hr.fer.objobl.shopking.view.viewstate.NotificationViewState
import hr.fer.objobl.shopking.view.viewstate.ShopViewState
import hr.fer.objobl.shopking.viewmodel.ShopsViewModel
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class ShopsFragment : Fragment(R.layout.fragment_shops) {

    private lateinit var binding: FragmentShopsBinding

    private val shopListAdapter: ShopListAdapter by lazy { ShopListAdapter { model.showShopOnMap(activity as AppCompatActivity, it) } }

    private val model: ShopsViewModel by inject(parameters = { parametersOf() })

    private val shopTopOffset: NonFirstItemOffsetDecoration by lazy {
        NonFirstItemOffsetDecoration(
            topOffset = resources.getDimensionPixelOffset(
                R.dimen.article_grid_item_offset
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShopsBinding.bind(view)

        view.isClickable = true
        initialiseView(view, savedInstanceState)
    }

    private fun initialiseView(view: View, savedInstanceState: Bundle?) {
        setupNotificationList()
        setupToolbar()
    }

    private fun setupToolbar() {
        binding.shopsToolbar.toolbarTitle.text = resources.getString(R.string.toolbar_shops_title)
        binding.shopsToolbar.toolbarIcon.setImageResource(R.drawable.ic_settings_red)
    }

    private fun setupNotificationList() {
        binding.shopsShopsList.apply {
            adapter = shopListAdapter
            addItemDecoration(shopTopOffset)
        }

        val categoriesObserver = Observer<List<ShopViewState>> { notifications ->
            shopListAdapter.submitList(notifications)
            shopListAdapter.notifyDataSetChanged()
        }

        model.shops.observe(viewLifecycleOwner, categoriesObserver)
    }

    companion object {
        const val TAG = "ShopsFragment"

        @JvmStatic
        fun newInstance() = ShopsFragment()
    }
}
