using System;
using Shopking.Models.Dto;

namespace Shopking.Models.Mapper
{
    public class FoodMapper
    {
        public static FoodDto map(Food food)
        {
            return new FoodDto(
                food.Id,
                food.Name,
                food.Company,
                food.Price,
                food.Sale,
                food.Mass
            );
        }
    }
}
