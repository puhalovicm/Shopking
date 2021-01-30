package hr.fer.objobl.shopking.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.databinding.FragmentRecipesBinding
import hr.fer.objobl.shopking.view.adapter.RecipeDifficultyListAdapter
import hr.fer.objobl.shopking.view.adapter.RecipeListAdapter
import hr.fer.objobl.shopking.view.adapter.decoration.IntermittentItemDecoration
import hr.fer.objobl.shopking.view.adapter.decoration.ItemOffsetDecoration
import hr.fer.objobl.shopking.view.adapter.decoration.LastItemDecoration
import hr.fer.objobl.shopking.view.viewstate.RecipeDifficultyViewState
import hr.fer.objobl.shopking.view.viewstate.RecipeViewState
import hr.fer.objobl.shopking.viewmodel.RecipesViewModel
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

private const val NUM_OF_COLUMNS = 2

class RecipesFragment : Fragment(R.layout.fragment_recipes) {

    private lateinit var binding: FragmentRecipesBinding

    private val recipeListAdapter: RecipeListAdapter by lazy { RecipeListAdapter { model.showRecipeDetails(activity as AppCompatActivity, it) } }
    private val difficultyListAdapter: RecipeDifficultyListAdapter by lazy { RecipeDifficultyListAdapter(model::selectDifficulty) }

    private val model: RecipesViewModel by inject(parameters = { parametersOf() })

    private val recipeTopOffsetDecoration: ItemOffsetDecoration by lazy {
        ItemOffsetDecoration(
            topOffset = resources.getDimensionPixelOffset(
                R.dimen.article_grid_item_offset
            )
        )
    }

    private val recipeLeftOffsetDecoration: ItemOffsetDecoration by lazy {
        ItemOffsetDecoration(
            leftOffset = resources.getDimensionPixelOffset(
                R.dimen.article_grid_item_offset
            )
        )
    }

    private val lastRecipeRightOffsetDecoration: IntermittentItemDecoration by lazy {
        IntermittentItemDecoration(
            n = NUM_OF_COLUMNS,
            rightOffset = resources.getDimensionPixelOffset(
                R.dimen.article_grid_item_offset
            )
        )
    }

    private val difficultyLeftOffsetDecoration: ItemOffsetDecoration by lazy {
        ItemOffsetDecoration(
            leftOffset = resources.getDimensionPixelOffset(
                R.dimen.category_item_offset
            )
        )
    }

    private val difficultyLastItemOffsetDecoration: LastItemDecoration by lazy {
        LastItemDecoration(
            rightOffset = resources.getDimensionPixelOffset(
                R.dimen.category_item_offset
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRecipesBinding.bind(view)

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
        binding.recipesToolbar.toolbarTitle.text = resources.getString(R.string.toolbar_recipes_title)
        binding.recipesToolbar.toolbarIcon.setImageResource(R.drawable.ic_recipe_red)
    }

    private fun setupSwipeRefreshLayout() {
        binding.recipesSwipeRefreshLayout.setColorSchemeResources(R.color.shopking_medium_blue)
        binding.recipesSwipeRefreshLayout.setOnRefreshListener {
            model.fetchArticles()
        }
    }

    private fun setupCategoryList() {
        binding.recipesDifficulties.apply {
            adapter = difficultyListAdapter
            addItemDecoration(difficultyLeftOffsetDecoration)
            addItemDecoration(difficultyLastItemOffsetDecoration)
        }

        val categoriesObserver = Observer<List<RecipeDifficultyViewState>> { categories ->
            difficultyListAdapter.submitList(categories)
            difficultyListAdapter.notifyDataSetChanged()
        }

        model.recipeDifficulties.observe(viewLifecycleOwner, categoriesObserver)
    }

    private fun setupArticleGrid() {
        binding.recipesRecyclerGrid.apply {
            adapter = recipeListAdapter
            layoutManager = GridLayoutManager(context, NUM_OF_COLUMNS, GridLayoutManager.VERTICAL, false)
            addItemDecoration(recipeTopOffsetDecoration)
            addItemDecoration(recipeLeftOffsetDecoration)
            addItemDecoration(lastRecipeRightOffsetDecoration)
        }

        val articlesObserver = Observer<List<RecipeViewState>> { articles ->
            recipeListAdapter.submitList(articles)
            binding.recipesSwipeRefreshLayout.isRefreshing = false
        }

        model.recipesViewState.observe(viewLifecycleOwner, articlesObserver)
    }

    companion object {
        const val TAG = "RecipesFragment"

        @JvmStatic
        fun newInstance() = RecipesFragment()
    }
}
