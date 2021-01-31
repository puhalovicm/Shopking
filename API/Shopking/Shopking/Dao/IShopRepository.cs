using System;
using System.Collections.Generic;
using System.Linq;
using NHibernate;
using Shopking.Models;
using Shopking.Models.Mapper;

namespace Shopking.Dao
{
    public interface IShopRepository
    {

        public IEnumerable<Shop> GetShops();
    }
}
