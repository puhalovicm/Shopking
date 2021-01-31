using System;
using System.Collections.Generic;
using Shopking.Dao;
using Shopking.Models;

namespace Shopking.Tests
{
    public class TestRecipeRepository: IRecipeRepository
    {
        private List<Recipe> recipes;

        public TestRecipeRepository(List<Recipe> recipes)
        {
            this.recipes = recipes;
        }

        IEnumerable<Recipe> IRecipeRepository.GetRecipes()
        {
            return recipes;
        }

        Recipe IRecipeRepository.GetRecipeById(long id)
        {
            return recipes.Find(r => r.Id == id);
        }

        IEnumerable<Recipe> IRecipeRepository.GetRecipesByDifficulty(RecipeDifficulty difficulty)
        {
            return recipes.FindAll(r => r.Difficulty == difficulty);
        }
    }
}
