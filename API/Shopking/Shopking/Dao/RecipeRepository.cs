using System;
using System.Collections.Generic;
using System.Linq;
using NHibernate;
using Shopking.Models;
using Shopking.Models.Mapper;

namespace Shopking.Dao
{
    public class RecipeRepository : IRecipeRepository
    {

        public IEnumerable<Recipe> GetRecipes()
        {
            using (ISession session = NHibernateSession.OpenSession())
            {
                return session.Query<Recipe>().ToList();
            }
        }

        public Recipe GetRecipeById(long id)
        {
            using (ISession session = NHibernateSession.OpenSession())
            {
                return session.Query<Recipe>().Where(r => r.Id == id).First();
            }
        }

        public IEnumerable<Recipe> GetRecipesByDifficulty(RecipeDifficulty difficulty)
        {
            using (ISession session = NHibernateSession.OpenSession())
            {
                return session.Query<Recipe>().Where(r => r.Difficulty == difficulty).ToList();
            }
        }

        public IEnumerable<Recipe> GetRecipesByIngredient(string ingredient)
        {
            using (ISession session = NHibernateSession.OpenSession())
            {
                return session.Query<Recipe>().Where(r => r.Ingredients.Select(i => i.Name).Contains(ingredient)).ToList();
            }
        }
    }
}
