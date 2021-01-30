package hr.fer.objobl.shopking.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.databinding.FragmentNotificationsBinding
import hr.fer.objobl.shopking.view.adapter.NotificationListAdapter
import hr.fer.objobl.shopking.view.adapter.decoration.NonFirstItemOffsetDecoration
import hr.fer.objobl.shopking.view.viewstate.NotificationViewState
import hr.fer.objobl.shopking.viewmodel.NotificationsViewModel
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class NotificationsFragment : Fragment(R.layout.fragment_notifications) {

    private lateinit var binding: FragmentNotificationsBinding

    private val notificationListAdapter: NotificationListAdapter by lazy { NotificationListAdapter() }

    private val model: NotificationsViewModel by inject(parameters = { parametersOf() })

    private val notificationTopOffset: NonFirstItemOffsetDecoration by lazy {
        NonFirstItemOffsetDecoration(
            topOffset = resources.getDimensionPixelOffset(
                R.dimen.article_grid_item_offset
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNotificationsBinding.bind(view)

        view.isClickable = true
        initialiseView(view, savedInstanceState)
    }

    private fun initialiseView(view: View, savedInstanceState: Bundle?) {
        setupNotificationList()
        setupToolbar()
    }

    private fun setupToolbar() {
        binding.notificationsToolbar.toolbarTitle.text = resources.getString(R.string.toolbar_notifications_title)
        binding.notificationsToolbar.toolbarIcon.setImageResource(R.drawable.ic_settings_red)
    }

    private fun setupNotificationList() {
        binding.notificationsNotificationsList.apply {
            adapter = notificationListAdapter
            addItemDecoration(notificationTopOffset)
        }

        val categoriesObserver = Observer<List<NotificationViewState>> { notifications ->
            notificationListAdapter.submitList(notifications)
            notificationListAdapter.notifyDataSetChanged()
        }

        model.notifications.observe(viewLifecycleOwner, categoriesObserver)
    }

    companion object {
        const val TAG = "NotificationsFragment"

        @JvmStatic
        fun newInstance() = NotificationsFragment()
    }
}
