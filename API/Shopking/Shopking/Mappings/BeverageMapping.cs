﻿using System;
using FluentNHibernate.Mapping;
using Shopking.Models;

namespace Shopking.Mappings
{
    public class BeverageMapping : ClassMap<Beverage>
    {
        public BeverageMapping()
        {
            Table("beverage");

            Id(x => x.Id).GeneratedBy.Native();
            Map(x => x.Name, "name");
            Map(x => x.Company, "company");
            Map(x => x.Price, "price");
            Map(x => x.Sale, "sale");
            Map(x => x.Volume, "volume");
        }
    }
}
