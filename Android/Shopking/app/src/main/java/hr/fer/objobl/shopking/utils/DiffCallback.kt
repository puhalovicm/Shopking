package hr.fer.objobl.shopking.utils

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import hr.fer.objobl.shopking.view.viewstate.ArticleViewState

class DiffCallback : DiffUtil.ItemCallback<ArticleViewState>() {
    override fun areItemsTheSame(oldItem: ArticleViewState, newItem: ArticleViewState): Boolean {
        return oldItem == newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: ArticleViewState, newItem: ArticleViewState): Boolean {
        return oldItem == newItem
    }
}
