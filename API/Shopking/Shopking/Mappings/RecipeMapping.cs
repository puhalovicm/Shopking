using System;
using FluentNHibernate.Mapping;
using Shopking.Models;

namespace Shopking.Mappings
{
    public class RecipeMapping : ClassMap<Recipe>
    {
        public RecipeMapping()
        {
            Id(x => x.Id).GeneratedBy.Native();
            Map(x => x.Name, "name");
            Map(x => x.Difficulty, "difficulty");
            Map(x => x.EstimatedTime, "estimated_time");
            Map(x => x.Description, "description");

            HasManyToMany(x => x.Ingredients)
                .Cascade.All()
                .Table("recipe_ingredient")
                .Not.LazyLoad()
                .Fetch.Join();


            Table("Recipe");
        }
    }
}
