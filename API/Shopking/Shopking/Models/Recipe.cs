using System;
using System.Collections.Generic;

namespace Shopking.Models
{
    public class Recipe
    {
        public virtual long Id { get; set; }
        public virtual string Name { get; set; }
        public virtual RecipeDifficulty Difficulty { get; set; }
        public virtual IList<Ingredient> Ingredients { get; set; }
        public virtual int EstimatedTime { get; set; }
        public virtual string Description { get; set; }

        public Recipe()
        {
        }
    }
}
