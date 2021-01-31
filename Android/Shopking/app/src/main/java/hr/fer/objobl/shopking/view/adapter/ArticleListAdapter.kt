package hr.fer.objobl.shopking.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.databinding.CardItemBinding
import hr.fer.objobl.shopking.utils.DiffCallback
import hr.fer.objobl.shopking.utils.load
import hr.fer.objobl.shopking.view.viewstate.ArticleViewState

typealias OnArticleClickListener = (Long) -> Unit

class ArticleListAdapter(
    private val onArticleClickListener: OnArticleClickListener,
    private val onShoppingListClickListener: OnArticleClickListener,
    private val onWishListClickListener: OnArticleClickListener
) : ListAdapter<ArticleViewState, ArticleListAdapter.ArticleViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ArticleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false), onArticleClickListener, onShoppingListClickListener, onWishListClickListener)

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ArticleViewHolder(
        itemView: View,
        private val onArticleClickListener: OnArticleClickListener,
        private val onShoppingListClickListener: OnArticleClickListener,
        private val onWishListClickListener: OnArticleClickListener
    ) : RecyclerView.ViewHolder(itemView) {
        private val binding: CardItemBinding = CardItemBinding.bind(itemView)

        fun bind(article: ArticleViewState) = with(itemView) {
            with(binding) {
                articleListItemName.text = article.name
                articleListItemDescription.text = article.description
                articleListItemPrice.text = article.price
                articleListItemImage.load(article.imageUrl)
                articleListItemSaleIcon.visibility = if (article.isOnSale) View.VISIBLE else View.INVISIBLE
                articleListItemShoppingList.isChecked = article.isOnShoppingList
                articleListItemWishList.isChecked = article.isOnWishList

                articleListItemShoppingList.setOnClickListener {
                    onShoppingListClickListener(article.id)
                }

                articleListItemWishList.setOnClickListener {
                    onWishListClickListener(article.id)
                }
            }

            setOnClickListener {
                onArticleClickListener(article.id)
            }
        }
    }
}
