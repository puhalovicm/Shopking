using System;
using FluentNHibernate.Mapping;
using Shopking.Models;

namespace Shopking.Mappings
{
    public class IngredientMapping : ClassMap<Ingredient>
    {
        public IngredientMapping()
        {
            Id(x => x.Id).GeneratedBy.Native();
            Map(x => x.Name);

            HasManyToMany(x => x.recipes)
                .Cascade.All()
                .Inverse()
                .Table("recipe_ingredient")
                .Not.LazyLoad()
                .Fetch.Join();

            Table("Ingredient");
        }
    }
}
