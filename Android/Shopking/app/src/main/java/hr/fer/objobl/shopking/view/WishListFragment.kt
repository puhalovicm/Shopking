package hr.fer.objobl.shopking.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.databinding.FragmentShoppingListBinding
import hr.fer.objobl.shopking.view.adapter.WishListAdapter
import hr.fer.objobl.shopking.view.adapter.decoration.NonFirstItemOffsetDecoration
import hr.fer.objobl.shopking.view.viewstate.ArticleWishListViewState
import hr.fer.objobl.shopking.viewmodel.WishListViewModel
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class WishListFragment : Fragment(R.layout.fragment_shopping_list) {

    private lateinit var binding: FragmentShoppingListBinding

    private val articleListAdapter: WishListAdapter by lazy { WishListAdapter() }

    private val model: WishListViewModel by inject(parameters = { parametersOf() })

    private val articleTopOffsetDecoration: NonFirstItemOffsetDecoration by lazy {
        NonFirstItemOffsetDecoration(
            topOffset = resources.getDimensionPixelOffset(
                R.dimen.article_grid_item_offset
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShoppingListBinding.bind(view)

        view.isClickable = true
        initialiseView(view, savedInstanceState)
    }

    private fun initialiseView(view: View, savedInstanceState: Bundle?) {
        setupArticleGrid()
        setupToolbar()
    }

    private fun setupToolbar() {
        binding.shoppingListToolbar.toolbarTitle.text = resources.getString(R.string.toolbar_wish_list_title)
        binding.shoppingListToolbar.toolbarIcon.setImageResource(R.drawable.ic_wish_list_red)
    }

    private fun setupArticleGrid() {
        binding.shoppingListItems.apply {
            adapter = articleListAdapter
            addItemDecoration(articleTopOffsetDecoration)
        }

        val articlesObserver = Observer<List<ArticleWishListViewState>> { articles ->
            articleListAdapter.submitList(articles)
        }

        model.articles.observe(viewLifecycleOwner, articlesObserver)
    }

    companion object {
        const val TAG = "WishListFragment"

        @JvmStatic
        fun newInstance() = WishListFragment()
    }
}
