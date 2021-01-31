using System;
using System.Collections.Generic;

namespace Shopking.Models
{
    public class Food : Item
    {

        public virtual string Mass { get; set; }
        public virtual IList<Recipe> Recipes { get; set; }

        public Food()
        {
        }
    }
}
