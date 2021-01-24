package hr.fer.objobl.shopking.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.databinding.ArticleListItemBinding
import hr.fer.objobl.shopking.utils.DiffCallback
import hr.fer.objobl.shopking.utils.load
import hr.fer.objobl.shopking.view.viewstate.ArticleViewState

class ArticleListAdapter : ListAdapter<ArticleViewState, ArticleListAdapter.ArticleViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ArticleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.article_list_item, parent, false))

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ArticleListItemBinding = ArticleListItemBinding.bind(itemView)

        fun bind(article: ArticleViewState) = with(itemView) {
            with(binding) {
                articleListItemName.text = article.name
                articleListItemDescription.text = article.description
                articleListItemPrice.text = article.price
                articleListItemImage.load(article.imageUrl)
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
