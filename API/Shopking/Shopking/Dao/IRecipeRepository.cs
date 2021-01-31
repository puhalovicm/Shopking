using System;
using System.Collections.Generic;
using System.Linq;
using NHibernate;
using Shopking.Models;
using Shopking.Models.Mapper;

namespace Shopking.Dao
{
    public interface IRecipeRepository
    {
        public IEnumerable<Recipe> GetRecipes();
        public Recipe GetRecipeById(long id);
        public IEnumerable<Recipe> GetRecipesByDifficulty(RecipeDifficulty difficulty);
    }
}
