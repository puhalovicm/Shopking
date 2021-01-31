using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using System.Web.Http.Results;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Shopking.Controllers;
using Shopking.Dao;
using Shopking.Models;

namespace Shopking.Tests
{
    [TestClass]
    public class ShopControllerTest
    {
        [TestMethod]
        public void GetAllShops_ShouldReturnAllShops()
        {
            var testShops = GetTestShops();
            var controller = new ShopController(GetRepository());

            var result = controller.Get() as List<Shop>;
            Assert.AreEqual(testShops.Count, result.Count);
        }

        private IShopRepository GetRepository()
        {
            return new TestShopRepository(GetTestShops());
        }

        private List<Shop> GetTestShops()
        {
            var testProducts = new List<Shop>();
            testProducts.Add(new Shop { Id = 1, Name = "Demo1", Address = "Unska 33, Zagreb" });
            testProducts.Add(new Shop { Id = 2, Name = "Demo2", Address = "Unska 31, Zagreb" });

            return testProducts;
        }
    }
}