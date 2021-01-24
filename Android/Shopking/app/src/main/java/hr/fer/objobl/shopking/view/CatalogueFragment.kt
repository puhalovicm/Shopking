package hr.fer.objobl.shopking.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.databinding.FragmentCatalogueBinding
import hr.fer.objobl.shopking.view.adapter.ArticleListAdapter
import hr.fer.objobl.shopking.view.adapter.decoration.IntermittentItemDecoration
import hr.fer.objobl.shopking.view.adapter.decoration.ItemOffsetDecoration
import hr.fer.objobl.shopking.view.viewstate.ArticleViewState
import hr.fer.objobl.shopking.viewmodel.CatalogueViewModel
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

private const val NUM_OF_COLUMNS = 2

class CatalogueFragment : Fragment(R.layout.fragment_catalogue) {

    private lateinit var binding: FragmentCatalogueBinding

    private val articleListAdapter: ArticleListAdapter by lazy { ArticleListAdapter() }

    private val model: CatalogueViewModel by inject(parameters = { parametersOf() })

    private val itemTopOffsetDecoration: ItemOffsetDecoration by lazy {
        ItemOffsetDecoration(
            topOffset = resources.getDimensionPixelOffset(
                R.dimen.article_grid_item_offset
            )
        )
    }

    private val itemLeftOffsetDecoration: ItemOffsetDecoration by lazy {
        ItemOffsetDecoration(
            leftOffset = resources.getDimensionPixelOffset(
                R.dimen.article_grid_item_offset
            )
        )
    }

    private val lastItemRightOffsetDecoration: IntermittentItemDecoration by lazy {
        IntermittentItemDecoration(
            n = NUM_OF_COLUMNS,
            rightOffset = resources.getDimensionPixelOffset(
                R.dimen.article_grid_item_offset
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCatalogueBinding.bind(view)

        view.isClickable = true // To avoid clicks passing through
        initialiseView(view, savedInstanceState)
    }

    private fun initialiseView(view: View, savedInstanceState: Bundle?) {
        binding.catalogueArticleGrid.apply {
            adapter = articleListAdapter
            layoutManager = GridLayoutManager(context, NUM_OF_COLUMNS, GridLayoutManager.VERTICAL, false)
            addItemDecoration(itemTopOffsetDecoration)
            addItemDecoration(itemLeftOffsetDecoration)
            addItemDecoration(lastItemRightOffsetDecoration)
        }

        val articlesObserver = Observer<List<ArticleViewState>> { articles ->
            articleListAdapter.submitList(articles)
        }

        model.articles.observe(viewLifecycleOwner, articlesObserver)
    }

    companion object {
        const val TAG = "CatalogueFragment"

        @JvmStatic
        fun newInstance() = CatalogueFragment()
    }
}
