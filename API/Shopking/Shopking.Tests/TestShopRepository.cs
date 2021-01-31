using System;
using System.Collections.Generic;
using Shopking.Dao;
using Shopking.Models;

namespace Shopking.Tests
{
    public class TestShopRepository : IShopRepository
    {
        private List<Shop> shops;

        public TestShopRepository(List<Shop> shops)
        {
            this.shops = shops;
        }

        IEnumerable<Shop> IShopRepository.GetShops()
        {
            return shops;
        }
    }
}
