using System;
using FluentNHibernate.Mapping;
using Shopking.Models;

namespace Shopking.Mappings
{
    public class ShopMapping : ClassMap<Shop>
    {
        public ShopMapping()
        {
            Id(x => x.Id).GeneratedBy.Native();
            Map(x => x.Name);
            Map(x => x.Address);
            Table("Shop");
        }
    }
}
