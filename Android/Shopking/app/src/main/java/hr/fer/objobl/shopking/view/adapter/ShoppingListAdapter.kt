package hr.fer.objobl.shopking.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.databinding.ShoppingListItemBinding
import hr.fer.objobl.shopking.utils.DiffCallback
import hr.fer.objobl.shopking.utils.load
import hr.fer.objobl.shopking.view.viewstate.ArticleShoppingListViewState

class ShoppingListAdapter : ListAdapter<ArticleShoppingListViewState, ShoppingListAdapter.ArticleShoppingListViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ArticleShoppingListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.shopping_list_item, parent, false))

    override fun onBindViewHolder(holder: ArticleShoppingListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ArticleShoppingListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ShoppingListItemBinding = ShoppingListItemBinding.bind(itemView)

        fun bind(article: ArticleShoppingListViewState) = with(itemView) {
            with(binding) {
                shoppingListItemName.text = article.name
                shoppingListItemDescription.text = article.description
                shoppingListItemPrice.text = article.price
                shoppingListItemImage.load(article.imageUrl)
                shoppingListItemQuantity.text = article.quantity.toString()


                shoppingListItemQuantityIncrease.setOnClickListener {
                    // TODO
                }

                shoppingListItemQuantityDecrease.setOnClickListener {
                    // TODO
                }

                shoppingListItemClose.setOnClickListener {
                    // TODO
                }
            }
        }
    }
}
