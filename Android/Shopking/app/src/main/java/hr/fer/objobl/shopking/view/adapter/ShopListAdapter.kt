package hr.fer.objobl.shopking.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.databinding.ShopItemBinding
import hr.fer.objobl.shopking.utils.DiffCallback
import hr.fer.objobl.shopking.view.viewstate.ShopViewState

typealias OnShopClickListener = (String) -> Unit

class ShopListAdapter(
    private val onShopClickListener: OnShopClickListener
) : ListAdapter<ShopViewState, ShopListAdapter.ShopViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ShopViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.shop_item, parent, false), onShopClickListener)

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ShopViewHolder(
        itemView: View,
        val onShopClickListener: OnShopClickListener
    ) : RecyclerView.ViewHolder(itemView) {
        private val binding: ShopItemBinding = ShopItemBinding.bind(itemView)

        fun bind(shop: ShopViewState) = with(itemView) {
            with(binding) {
                shopItemName.text = shop.address
                shopItemShowOnMap.setOnClickListener {
                    onShopClickListener(shop.address)
                }
            }
        }
    }
}
