using System;
using System.Linq;
using Shopking.Models.Dto;

namespace Shopking.Models.Mapper
{
    public class IngredientMapper
    {

        public static IngredientDto map(Ingredient ingredient)
        {
            return new IngredientDto(
                ingredient.Id,
                ingredient.Name
            );
        }
    }
}
