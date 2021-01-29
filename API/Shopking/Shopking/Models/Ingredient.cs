using System;
using System.Collections.Generic;

namespace Shopking.Models
{
    public class Ingredient
    {
        public virtual long Id { get; set; }
        public virtual string Name { get; set; }
        public virtual IList<Recipe> recipes { get; set; }

        public Ingredient()
        {
        }
    }
}
