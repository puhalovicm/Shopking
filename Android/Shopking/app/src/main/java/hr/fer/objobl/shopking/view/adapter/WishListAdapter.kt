package hr.fer.objobl.shopking.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.databinding.WishListItemBinding
import hr.fer.objobl.shopking.utils.DiffCallback
import hr.fer.objobl.shopking.utils.load
import hr.fer.objobl.shopking.view.viewstate.ArticleShoppingListViewState
import hr.fer.objobl.shopking.view.viewstate.ArticleWishListViewState

class WishListAdapter : ListAdapter<ArticleWishListViewState, WishListAdapter.ArticleShoppingListViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ArticleShoppingListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.wish_list_item, parent, false))

    override fun onBindViewHolder(holder: ArticleShoppingListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ArticleShoppingListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: WishListItemBinding = WishListItemBinding.bind(itemView)

        fun bind(article: ArticleWishListViewState) = with(itemView) {
            with(binding) {
                wishListItemName.text = article.name
                wishListItemDescription.text = article.description
                wishListItemPrice.text = article.price
                wishListItemImage.load(article.imageUrl)
                wishListItemSaleIcon.visibility = if (article.isOnSale) View.VISIBLE else View.GONE


                wishListItemClose.setOnClickListener {
                    // TODO
                }
            }
        }
    }
}
