using System;
using System.Linq;
using Shopking.Models.Dto;

namespace Shopking.Models.Mapper
{
    public class RecipeMapper
    {

        public static RecipeDto map(Recipe recipe)
        {
            return new RecipeDto(
                recipe.Id,
                recipe.Name,
                recipe.Difficulty,
                recipe.Ingredients.Select(i => i.Name).ToList(),
                recipe.EstimatedTime,
                recipe.Description
            );
        }
    }
}
