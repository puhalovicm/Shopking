package hr.fer.objobl.shopking.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.databinding.IngredientItemBinding
import hr.fer.objobl.shopking.utils.DiffCallback
import hr.fer.objobl.shopking.view.viewstate.IngredientViewState

class IngredientListAdapter :
    ListAdapter<IngredientViewState, IngredientListAdapter.IngredientViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        IngredientViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.ingredient_item, parent, false))

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun submitList(list: List<IngredientViewState>?) {

        super.submitList(list)
    }

    class IngredientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: IngredientItemBinding = IngredientItemBinding.bind(itemView)

        fun bind(ingredient: IngredientViewState) = with(itemView) {
            with(binding) {
                ingredientItemName.text = ingredient.name
                ingredientItemShoppingList.isChecked = ingredient.isOnShoppingList
                ingredientItemWishList.isChecked = ingredient.isOnWishList
            }
        }
    }
}
