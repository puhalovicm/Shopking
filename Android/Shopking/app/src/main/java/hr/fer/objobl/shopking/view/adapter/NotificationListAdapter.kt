package hr.fer.objobl.shopking.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.databinding.NotificationItemBinding
import hr.fer.objobl.shopking.utils.DiffCallback
import hr.fer.objobl.shopking.view.viewstate.NotificationViewState

class NotificationListAdapter :
    ListAdapter<NotificationViewState, NotificationListAdapter.NotificationViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NotificationViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.notification_item, parent, false))

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class NotificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: NotificationItemBinding = NotificationItemBinding.bind(itemView)

        fun bind(notification: NotificationViewState) = with(itemView) {
            with(binding) {
                notificationItemName.text = notification.message
                notificationItemClose.setOnClickListener {
                    // TODO
                }
            }
        }
    }
}
