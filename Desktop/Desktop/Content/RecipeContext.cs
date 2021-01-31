using Desktop.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Desktop.Content
{
    class RecipeContext
    {
        public List<Recipe> Recipes = new List<Recipe> { new Recipe(1, "Apple pie", "easy", ingredients: new ItemContext().Items, 20, "Preheat" +
                                                            " oven to 375°. In a small bowl, combine sugars, flour and spices; set aside. In a large bowl, " +
                                                            "toss apples with lemon juice. Add sugar mixture; toss to coat."),
                                                     new Recipe(1, "Apple pie", "easy", ingredients: new ItemContext().Items, 20, "Preheat" +
                                                        " oven to 375°. In a small bowl, combine sugars, flour and spices; set aside. In a large bowl, " +
                                                         "toss apples with lemon juice. Add sugar mixture; toss to coat.")};
    }
}
