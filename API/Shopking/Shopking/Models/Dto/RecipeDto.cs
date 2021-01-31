using System;
using System.Collections.Generic;

namespace Shopking.Models.Dto
{
    public class RecipeDto
    {
        public virtual long Id { get; set; }
        public virtual string Name { get; set; }
        public virtual string Difficulty { get; set; }
        public virtual IList<FoodDto> Ingredients { get; set; }
        public virtual int EstimatedTime { get; set; }
        public virtual string Description { get; set; }

        public RecipeDto(long id, string name, string difficulty, IList<FoodDto> ingredients, int estimatedTime, string description)
        {
            Id = id;
            Name = name;
            Difficulty = difficulty;
            Ingredients = ingredients;
            EstimatedTime = estimatedTime;
            Description = description;
        }
    }
}
