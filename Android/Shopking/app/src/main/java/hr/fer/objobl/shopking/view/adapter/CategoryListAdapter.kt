package hr.fer.objobl.shopking.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.databinding.RoundItemBinding
import hr.fer.objobl.shopking.utils.DiffCallback
import hr.fer.objobl.shopking.view.viewstate.CategoryViewState

typealias OnCategoryClickListener = (String) -> Unit

class CategoryListAdapter(
    private val onCategoryClickListener: OnCategoryClickListener
) : ListAdapter<CategoryViewState, CategoryListAdapter.CategoryViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.round_item, parent, false),
            onCategoryClickListener
        )

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CategoryViewHolder(
        itemView: View,
        private val onCategoryClickListener: OnCategoryClickListener
    ) : RecyclerView.ViewHolder(itemView) {
        private val binding: RoundItemBinding = RoundItemBinding.bind(itemView)

        fun bind(category: CategoryViewState) = with(itemView) {
            with(binding) {
                roundItemName.text = category.name
                roundItemName.isSelected = category.isSelected
            }

            setOnClickListener { onCategoryClickListener(category.name) }
        }
    }
}
