package hr.fer.objobl.shopking.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.databinding.FragmentInformationBinding
import hr.fer.objobl.shopking.view.adapter.NotificationListAdapter
import hr.fer.objobl.shopking.view.adapter.ShopListAdapter
import hr.fer.objobl.shopking.view.adapter.decoration.NonFirstItemOffsetDecoration
import hr.fer.objobl.shopking.view.viewstate.NotificationViewState
import hr.fer.objobl.shopking.view.viewstate.ShopViewState
import hr.fer.objobl.shopking.viewmodel.InformationViewModel
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class InformationFragment : Fragment(R.layout.fragment_information) {

    private lateinit var binding: FragmentInformationBinding

    private val notificationListAdapter: NotificationListAdapter by lazy { NotificationListAdapter() }
    private val shopListAdapter: ShopListAdapter by lazy { ShopListAdapter { model.showShopOnMap(activity as AppCompatActivity, it) } }

    private val model: InformationViewModel by inject(parameters = { parametersOf() })

    private val notificationTopOffset: NonFirstItemOffsetDecoration by lazy {
        NonFirstItemOffsetDecoration(
            topOffset = resources.getDimensionPixelOffset(
                R.dimen.article_grid_item_offset
            )
        )
    }

    private val shopTopOffset: NonFirstItemOffsetDecoration by lazy {
        NonFirstItemOffsetDecoration(
            topOffset = resources.getDimensionPixelOffset(
                R.dimen.article_grid_item_offset
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInformationBinding.bind(view)

        view.isClickable = true
        initialiseView(view, savedInstanceState)
    }

    private fun initialiseView(view: View, savedInstanceState: Bundle?) {
        setupNotificationList()
        setupShopList()
        setupToolbar()
    }

    private fun setupToolbar() {
        binding.informationToolbar.toolbarTitle.text = resources.getString(R.string.toolbar_information_title)
        binding.informationToolbar.toolbarIcon.setImageResource(R.drawable.ic_settings_red)
    }

    private fun setupNotificationList() {
        binding.informationNotificationsList.apply {
            adapter = notificationListAdapter
            addItemDecoration(notificationTopOffset)
        }

        val categoriesObserver = Observer<List<NotificationViewState>> { notifications ->
            notificationListAdapter.submitList(notifications)
            notificationListAdapter.notifyDataSetChanged()
        }

        model.notifications.observe(viewLifecycleOwner, categoriesObserver)

        binding.informationNotificationsSeeAllButton.setOnClickListener {
            model.showNotificationsScreen(this.activity as AppCompatActivity)
        }
    }

    private fun setupShopList() {
        binding.informationShopsList.apply {
            adapter = shopListAdapter
            addItemDecoration(shopTopOffset)
        }

        val categoriesObserver = Observer<List<ShopViewState>> { shops ->
            shopListAdapter.submitList(shops)
            shopListAdapter.notifyDataSetChanged()
        }

        model.shops.observe(viewLifecycleOwner, categoriesObserver)

        binding.informationShopsSeeAllButton.setOnClickListener {
            model.showShopsScreen(this.activity as AppCompatActivity)
        }
    }

    companion object {
        const val TAG = "InformationFragment"

        @JvmStatic
        fun newInstance() = InformationFragment()
    }
}
