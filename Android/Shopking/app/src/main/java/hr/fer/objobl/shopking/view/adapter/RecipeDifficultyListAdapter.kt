package hr.fer.objobl.shopking.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.databinding.RoundItemBinding
import hr.fer.objobl.shopking.utils.DiffCallback
import hr.fer.objobl.shopking.view.viewstate.RecipeDifficultyViewState

typealias OnDifficultyClickListener = (String) -> Unit

class RecipeDifficultyListAdapter(
    private val onCategoryClickListener: OnDifficultyClickListener
) : ListAdapter<RecipeDifficultyViewState, RecipeDifficultyListAdapter.DifficultyViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DifficultyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.round_item, parent, false),
            onCategoryClickListener
        )

    override fun onBindViewHolder(holder: DifficultyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DifficultyViewHolder(
        itemView: View,
        private val onCategoryClickListener: OnDifficultyClickListener
    ) : RecyclerView.ViewHolder(itemView) {
        private val binding: RoundItemBinding = RoundItemBinding.bind(itemView)

        fun bind(difficulty: RecipeDifficultyViewState) = with(itemView) {
            with(binding) {
                roundItemName.text = difficulty.name
                roundItemName.isSelected = difficulty.isSelected
            }

            setOnClickListener { onCategoryClickListener(difficulty.name) }
        }
    }
}
