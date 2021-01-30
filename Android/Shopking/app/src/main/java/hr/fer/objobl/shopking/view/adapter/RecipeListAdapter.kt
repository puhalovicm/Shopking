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
import hr.fer.objobl.shopking.view.viewstate.RecipeViewState

typealias OnRecipeClickListener = (Long) -> Unit

class RecipeListAdapter(
    private val onRecipeClickListener: OnRecipeClickListener
) : ListAdapter<RecipeViewState, RecipeListAdapter.RecipeViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RecipeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false),
            onRecipeClickListener
        )

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class RecipeViewHolder(
        itemView: View,
        private val onRecipeClickListener: OnRecipeClickListener
    ) : RecyclerView.ViewHolder(itemView) {
        private val binding: CardItemBinding = CardItemBinding.bind(itemView)

        fun bind(recipe: RecipeViewState) = with(itemView) {
            with(binding) {
                articleListItemName.text = recipe.name
                articleListItemDescription.text = "${recipe.difficulty} • ${recipe.timeEstimated} min"
                articleListItemPrice.text = recipe.totalPrice.toString()
                articleListItemImage.load(recipe.imageUrl)
                articleListItemSaleIcon.visibility = View.GONE
                articleListItemShoppingList.visibility = View.GONE
                articleListItemWishList.visibility = View.GONE
            }

            setOnClickListener {
                onRecipeClickListener(recipe.id)
            }
        }
    }
}
