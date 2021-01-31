using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Desktop.Model
{
    public class Recipe
    {
        public virtual long Id { get; set; }
        public virtual string Name { get; set; }
        public virtual string Difficulty { get; set; }
        public virtual List<Item> Ingredients { get; set; }
        public virtual int EstimatedTime { get; set; }
        public virtual string Description { get; set; }

        public Recipe(long id, string name, string difficulty, List<Item> ingredients, int estimatedTime, string description) 
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
