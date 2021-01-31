using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web.Http.Results;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Shopking.Controllers;
using Shopking.Dao;
using Shopking.Models;

namespace Shopking.Tests
{
    [TestClass]
    public class NotificationControllerTest
    {
        [TestMethod]
        public void GetNotifications_ShouldReturnSaleItems()
        {
            var controller = new NotificationsController(GetRepository());

            var ids = new List<long>();
            ids.Add(1);
            ids.Add(2);

            var result = controller.GetNotificaitons(ids);
            Assert.AreEqual(result.ToList().Count, 1);
        }

        private IItemRepository GetRepository()
        {
            return new TestItemRepository(GetTestFood());
        }

        private List<Item> GetTestFood()
        {
            var testProducts = new List<Item>();
            testProducts.Add(new Food { Id = 1, Name = "Demo1", Company = "KRAS", Price = "100 KN", Sale = true, Mass = "100 kg", Recipes = new List<Recipe>() });
            testProducts.Add(new Food { Id = 2, Name = "Demo2", Company = "KRAS", Price = "200 KN", Sale = false, Mass = "200 kg", Recipes = new List<Recipe>() });

            return testProducts;
        }
    }
}