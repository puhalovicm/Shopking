using System;
using FluentNHibernate.Mapping;
using Shopking.Models;

namespace Shopking.Mappings
{
    public class ItemMapping : ClassMap<Item>
    {
        public ItemMapping()
        {
            Table("items");
            ReadOnly();

            Id(x => x.Id).Column("item_id").GeneratedBy.Assigned();
            Map(x => x.Name, "name");
            Map(x => x.Company, "company");
            Map(x => x.Price, "price");
            Map(x => x.Sale, "sale");

        }
    }
}
