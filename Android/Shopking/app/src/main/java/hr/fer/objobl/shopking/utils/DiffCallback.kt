package hr.fer.objobl.shopking.utils

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

abstract class DiffCallbackViewState(open val id: Any? = null)

class DiffCallback<T: DiffCallbackViewState> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}
