package hr.fer.objobl.shopking.viewmodel

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.fer.objobl.shopking.data.mapper.mapToDetailsViewState
import hr.fer.objobl.shopking.data.mapper.mapToRecipeDifficultyViewStateList
import hr.fer.objobl.shopking.data.mapper.mapToViewStateList
import hr.fer.objobl.shopking.data.model.Recipe
import hr.fer.objobl.shopking.data.source.RecipeDifficultiesDataSource
import hr.fer.objobl.shopking.data.source.RecipesDataSource
import hr.fer.objobl.shopking.navigation.NavigationManager
import hr.fer.objobl.shopking.view.viewstate.RecipeDifficultyViewState
import hr.fer.objobl.shopking.view.viewstate.RecipeViewState

class RecipesViewModel(
    private val recipesDataSource: RecipesDataSource,
    private val recipeDifficultiesDataSource: RecipeDifficultiesDataSource,
    private val navigationManager: NavigationManager
) : ViewModel() {

    val recipes: MutableLiveData<List<Recipe>> by lazy { MutableLiveData(recipesDataSource.recipes.value) }
    val recipesViewState: MutableLiveData<List<RecipeViewState>> by lazy { MutableLiveData<List<RecipeViewState>>() }

    val recipeDifficulties: MutableLiveData<List<RecipeDifficultyViewState>> by lazy {
        MutableLiveData(
            recipeDifficultiesDataSource.difficulties.value?.mapToRecipeDifficultyViewStateList()
                ?.mapIndexed { index, categoryViewState ->
                    if (index == 0) {
                        categoryViewState.isSelected = true
                    }

                    categoryViewState
                }
        )
    }

    init {
        recipes.observeForever {
            recipesViewState.postValue(it.mapToViewStateList())
        }
    }

    fun fetchArticles() {
        recipes.value = recipes.value!!
    }

    fun selectDifficulty(difficulty: String) {
        recipeDifficulties.value = recipeDifficulties.value?.map { RecipeDifficultyViewState(it.name, it.name == difficulty) }
    }

    fun showRecipeDetails(activity: AppCompatActivity, id: Long) {
        recipes.value?.first { it.id == id }.let {
            navigationManager.showRecipeDetails(activity, it!!.mapToDetailsViewState())
        }
    }
}
