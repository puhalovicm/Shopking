package hr.fer.objobl.shopking.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.databinding.ArticleListItemBinding
import hr.fer.objobl.shopking.view.adapter.util.DiffCallback

class ArticleListAdapter : ListAdapter<ArticleViewState, ArticleListAdapter.ItemViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.article_list_item, parent, false))

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ArticleListItemBinding = ArticleListItemBinding.bind(itemView)

        fun bind(article: ArticleViewState) = with(itemView) {
            with(binding) {
                articleListItemName.text = article.name
                articleListItemDescription.text = article.description
                articleListItemPrice.text = article.price
                articleListItemImage.setImageResource(article.image)
                articleListItemSaleIcon.visibility = if (article.isOnSale) View.VISIBLE else View.GONE
                articleListItemShoppingList.isChecked = article.isOnShoppingList
                articleListItemWishList.isChecked = article.isOnWishList
            }

            setOnClickListener {
                // TODO: Handle on click
            }
        }
    }
}
