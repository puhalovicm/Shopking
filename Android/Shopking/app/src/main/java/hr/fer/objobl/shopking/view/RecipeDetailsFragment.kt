package hr.fer.objobl.shopking.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.data.mapper.mapToIngredientViewStateList
import hr.fer.objobl.shopking.databinding.FragmentRecipeDetailsBinding
import hr.fer.objobl.shopking.view.adapter.IngredientListAdapter
import hr.fer.objobl.shopking.view.adapter.decoration.ItemOffsetDecoration
import hr.fer.objobl.shopking.view.adapter.decoration.NonFirstItemOffsetDecoration
import hr.fer.objobl.shopking.view.viewstate.RecipeDetailsViewState
import hr.fer.objobl.shopking.viewmodel.RecipeDetailsViewModel
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class RecipeDetailsFragment : Fragment(R.layout.fragment_recipe_details) {

    private lateinit var binding: FragmentRecipeDetailsBinding

    private val ingredientListAdapter: IngredientListAdapter by lazy { IngredientListAdapter() }

    private val model: RecipeDetailsViewModel by inject(parameters = { parametersOf() })

    private val ingredientTopOffset: NonFirstItemOffsetDecoration by lazy {
        NonFirstItemOffsetDecoration(
            topOffset = resources.getDimensionPixelOffset(
                R.dimen.article_grid_item_offset
            )
        )
    }

    private val recipeDetailsViewState: RecipeDetailsViewState by lazy {
        requireArguments().getSerializable(
            RECIPE_DETAILS_STATE
        ) as RecipeDetailsViewState
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRecipeDetailsBinding.bind(view)

        view.isClickable = true
        initialiseView(view, savedInstanceState)
    }

    private fun initialiseView(view: View, savedInstanceState: Bundle?) {
        setupIngredientsRecyclerView()
        setupRecipeDescription()
        setupToolbar()
    }

    private fun setupRecipeDescription() {
        binding.recipeDetailsRecipeDesciption.text = recipeDetailsViewState.description
    }

    private fun setupToolbar() {
        binding.recipeDetailsToolbar.recipeToolbarTitle.text = recipeDetailsViewState.name
        binding.recipeDetailsToolbar.recipeToolbarIcon.setImageResource(R.drawable.ic_recipe_red)
        binding.recipeDetailsToolbar.recipeToolbarDescription.text =
            "${recipeDetailsViewState.difficulty} • ${recipeDetailsViewState.timeEstimated} min"
    }

    private fun setupIngredientsRecyclerView() {
        binding.recipeDetailsIngredientsList.apply {
            adapter = ingredientListAdapter
            addItemDecoration(ingredientTopOffset)
        }

        view?.post {
            Log.d("coin", recipeDetailsViewState.ingredients.toString())
            ingredientListAdapter.submitList(recipeDetailsViewState.ingredients.mapToIngredientViewStateList())
            ingredientListAdapter.notifyDataSetChanged()
        }
    }

    companion object {
        const val TAG = "RecipeDetailsFragment"
        const val RECIPE_DETAILS_STATE = "RECIPE_DETAILS_STATE"

        @JvmStatic
        fun newInstance(viewState: RecipeDetailsViewState) = RecipeDetailsFragment().apply {
            arguments = Bundle().apply {
                putSerializable(RECIPE_DETAILS_STATE, viewState)
            }
        }
    }
}
