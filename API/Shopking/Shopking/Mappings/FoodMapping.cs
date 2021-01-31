using System;
using FluentNHibernate.Mapping;
using Shopking.Models;

namespace Shopking.Mappings
{
    public class FoodMapping : ClassMap<Food>
    {
        public FoodMapping()
        {
            Table("food");

            Id(x => x.Id).GeneratedBy.Native();
            Map(x => x.Name, "name");
            Map(x => x.Company, "company");
            Map(x => x.Price, "price");
            Map(x => x.Sale, "sale");
            Map(x => x.Mass, "mass");

            HasManyToMany(x => x.Recipes)
                            .Cascade.All()
                            .Inverse()
                            .Table("recipe_food")
                            .Not.LazyLoad()
                            .Fetch.Join();
        }
    }
}
