package hr.fer.objobl.shopking.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.databinding.FragmentCatalogueBinding
import hr.fer.objobl.shopking.view.adapter.ArticleListAdapter
import hr.fer.objobl.shopking.view.adapter.CategoryListAdapter
import hr.fer.objobl.shopking.view.adapter.decoration.IntermittentItemDecoration
import hr.fer.objobl.shopking.view.adapter.decoration.ItemOffsetDecoration
import hr.fer.objobl.shopking.view.adapter.decoration.LastItemDecoration
import hr.fer.objobl.shopking.view.viewstate.ArticleViewState
import hr.fer.objobl.shopking.view.viewstate.CategoryViewState
import hr.fer.objobl.shopking.viewmodel.CatalogueViewModel
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

private const val NUM_OF_COLUMNS = 2

class CatalogueFragment : Fragment(R.layout.fragment_catalogue) {

    private lateinit var binding: FragmentCatalogueBinding

    private val articleListAdapter: ArticleListAdapter by lazy { ArticleListAdapter { model.showArticleDetails(activity as AppCompatActivity, it) } }
    private val categoryListAdapter: CategoryListAdapter by lazy { CategoryListAdapter(model::selectCategory) }

    private val model: CatalogueViewModel by inject(parameters = { parametersOf() })

    private val articleTopOffsetDecoration: ItemOffsetDecoration by lazy {
        ItemOffsetDecoration(
            topOffset = resources.getDimensionPixelOffset(
                R.dimen.article_grid_item_offset
            )
        )
    }

    private val articleLeftOffsetDecoration: ItemOffsetDecoration by lazy {
        ItemOffsetDecoration(
            leftOffset = resources.getDimensionPixelOffset(
                R.dimen.article_grid_item_offset
            )
        )
    }

    private val lastArticleRightOffsetDecoration: IntermittentItemDecoration by lazy {
        IntermittentItemDecoration(
            n = NUM_OF_COLUMNS,
            rightOffset = resources.getDimensionPixelOffset(
                R.dimen.article_grid_item_offset
            )
        )
    }

    private val categoryLeftOffsetDecoration: ItemOffsetDecoration by lazy {
        ItemOffsetDecoration(
            leftOffset = resources.getDimensionPixelOffset(
                R.dimen.category_item_offset
            )
        )
    }

    private val categoryLastItemOffsetDecoration: LastItemDecoration by lazy {
        LastItemDecoration(
            rightOffset = resources.getDimensionPixelOffset(
                R.dimen.category_item_offset
            )
        )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCatalogueBinding.bind(view)

        view.isClickable = true
        initialiseView(view, savedInstanceState)
    }

    private fun initialiseView(view: View, savedInstanceState: Bundle?) {
        setupCategoryList()
        setupArticleGrid()
        setupSwipeRefreshLayout()
        setupToolbar()
    }

    private fun setupToolbar() {
        binding.catalogueToolbar.toolbarTitle.text = resources.getString(R.string.toolbar_catalogue_title)
        binding.catalogueToolbar.toolbarIcon.setImageResource(R.drawable.ic_catalouge_red)
    }

    private fun setupSwipeRefreshLayout() {
        binding.catalogueSwipeRefreshLayout.setColorSchemeResources(R.color.shopking_medium_blue)
        binding.catalogueSwipeRefreshLayout.setOnRefreshListener {
            model.fetchArticles()
        }
    }

    private fun setupCategoryList() {
        binding.catalogueCategories.apply {
            adapter = categoryListAdapter
            addItemDecoration(categoryLeftOffsetDecoration)
            addItemDecoration(categoryLastItemOffsetDecoration)
        }

        val categoriesObserver = Observer<List<CategoryViewState>> { categories ->
            categoryListAdapter.submitList(categories)
            categoryListAdapter.notifyDataSetChanged()
        }

        model.categories.observe(viewLifecycleOwner, categoriesObserver)
    }

    private fun setupArticleGrid() {
        binding.catalogueArticleGrid.apply {
            adapter = articleListAdapter
            layoutManager = GridLayoutManager(context, NUM_OF_COLUMNS, GridLayoutManager.VERTICAL, false)
            addItemDecoration(articleTopOffsetDecoration)
            addItemDecoration(articleLeftOffsetDecoration)
            addItemDecoration(lastArticleRightOffsetDecoration)
        }

        val articlesObserver = Observer<List<ArticleViewState>> { articles ->
            articleListAdapter.submitList(articles)
            binding.catalogueSwipeRefreshLayout.isRefreshing = false
        }

        model.articles.observe(viewLifecycleOwner, articlesObserver)
    }

    companion object {
        const val TAG = "CatalogueFragment"

        @JvmStatic
        fun newInstance() = CatalogueFragment()
    }
}
