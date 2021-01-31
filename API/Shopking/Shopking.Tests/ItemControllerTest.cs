using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web.Http.Results;
using Microsoft.AspNetCore.Mvc;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Shopking.Controllers;
using Shopking.Dao;
using Shopking.Models;

namespace Shopking.Tests
{
    [TestClass]
    public class ItemControllerTest
    {
        [TestMethod]
        public void GetAllItems_ShouldReturnAllItems()
        {
            var controller = new ItemController(GetRepository());

            var result = controller.Get();
            Assert.AreEqual(result.ToList().Count, GetTestItems().Count);
        }

        [TestMethod]
        public void GetItemsDetails_ShouldReturnItem()
        {
            var controller = new ItemController(GetRepository());

            var result = controller.GetItemDetails(1) as OkObjectResult;
            Assert.IsNotNull(result);
            Assert.AreEqual(200, result.StatusCode);
        }

        [TestMethod]
        public void GetAllFood_ShouldReturnFood()
        {
            var controller = new ItemController(GetRepository());

            var result = controller.GetFoods();
            Assert.AreEqual(result.ToList().Count, GetTestFood().Count);
        }

        [TestMethod]
        public void GetFoodDetails_ShouldReturnFood()
        {
            var controller = new ItemController(GetRepository());

            var result = controller.GetFoodDetails(1) as OkObjectResult;
            Assert.IsNotNull(result);
            Assert.AreEqual(200, result.StatusCode);
        }

        [TestMethod]
        public void GetAllBeverages_ShouldReturnBeverages()
        {
            var controller = new ItemController(GetRepository());

            var result = controller.GetBeverages();
            Assert.AreEqual(result.ToList().Count, GetTestBeverages().Count);
        }

        [TestMethod]
        public void GetBeverageDetails_ShouldReturnBeverage()
        {
            var controller = new ItemController(GetRepository());

            var result = controller.GetBeverageDetails(1) as OkObjectResult;
            Assert.IsNotNull(result);
            Assert.AreEqual(200, result.StatusCode);
        }

        [TestMethod]
        public void GetAllClothing_ShouldReturnClothing()
        {
            var controller = new ItemController(GetRepository());

            var result = controller.GetClothings();
            Assert.AreEqual(result.ToList().Count, GetTestClothes().Count);
        }

        [TestMethod]
        public void GetClothingDetails_ShouldReturnClothing()
        {
            var controller = new ItemController(GetRepository());

            var result = controller.GetClothingDetails(1) as OkObjectResult;
            Assert.IsNotNull(result);
            Assert.AreEqual(200, result.StatusCode);
        }

        [TestMethod]
        public void GetAllDevices_ShouldReturnDevices()
        {
            var controller = new ItemController(GetRepository());

            var result = controller.GetDevices();
            Assert.AreEqual(result.ToList().Count, GetTestDevices().Count);
        }

        [TestMethod]
        public void GetDevicesDetails_ShouldReturnDevice()
        {
            var controller = new ItemController(GetRepository());

            var result = controller.GetDeviceDetails(1) as OkObjectResult;
            Assert.IsNotNull(result);
            Assert.AreEqual(200, result.StatusCode);
        }

        [TestMethod]
        public void GetAllToiletries_ShouldReturnToiletries()
        {
            var controller = new ItemController(GetRepository());

            var result = controller.GetToileries();
            Assert.AreEqual(result.ToList().Count, GetTestToiletries().Count);
        }

        [TestMethod]
        public void GetToiletryDetails_ShouldReturnToiletry()
        {
            var controller = new ItemController(GetRepository());

            var result = controller.GetToiletryDetails(1) as OkObjectResult;
            Assert.IsNotNull(result);
            Assert.AreEqual(200, result.StatusCode);
        }

        [TestMethod]
        public void GetCategories_ShouldReturnCategories()
        {
            var controller = new ItemController(GetRepository());

            var result = controller.GetCategories();
            Assert.AreEqual(result.ToList().Count, GetTestCategories().Count);
        }

        private IItemRepository GetRepository()
        {
            return new TestItemRepository(
                GetTestItems(),
                GetTestFood(),
                GetTestBeverages(),
                GetTestToiletries(),
                GetTestClothes(),
                GetTestDevices()
            );
        }

        private List<Item> GetTestItems()
        {
            var testProducts = new List<Item>();
            testProducts.Add(new Food { Id = 1, Name = "Demo1", Company = "KRAS", Price = "100 KN", Sale = true, Mass = "100 kg", Recipes = new List<Recipe>() });
            testProducts.Add(new Food { Id = 2, Name = "Demo2", Company = "KRAS", Price = "200 KN", Sale = false, Mass = "200 kg", Recipes = new List<Recipe>() });
            testProducts.Add(new Food { Id = 3, Name = "Demo3", Company = "KRAS", Price = "200 KN", Sale = false, Mass = "300 kg", Recipes = new List<Recipe>() });

            return testProducts;
        }

        private List<Food> GetTestFood()
        {
            var testProducts = new List<Food>();
            testProducts.Add(new Food { Id = 1, Name = "Demo1", Company = "KRAS", Price = "100 KN", Sale = true, Mass = "100 kg", Recipes = new List<Recipe>() });
            testProducts.Add(new Food { Id = 2, Name = "Demo2", Company = "KRAS", Price = "200 KN", Sale = false, Mass = "200 kg", Recipes = new List<Recipe>() });
            testProducts.Add(new Food { Id = 3, Name = "Demo3", Company = "KRAS", Price = "200 KN", Sale = false, Mass = "300 kg", Recipes = new List<Recipe>() });

            return testProducts;
        }

        private List<Beverage> GetTestBeverages()
        {
            var testProducts = new List<Beverage>();
            testProducts.Add(new Beverage { Id = 1, Name = "Demo1", Company = "KRAS", Price = "100 KN", Sale = true, Volume = "100 L" });
            testProducts.Add(new Beverage { Id = 2, Name = "Demo2", Company = "KRAS", Price = "200 KN", Sale = false, Volume = "200 L" });
            testProducts.Add(new Beverage { Id = 3, Name = "Demo3", Company = "KRAS", Price = "200 KN", Sale = false, Volume = "300 L" });

            return testProducts;
        }

        private List<Toiletry> GetTestToiletries()
        {
            var testProducts = new List<Toiletry>();
            testProducts.Add(new Toiletry { Id = 1, Name = "Demo1", Company = "KRAS", Price = "100 KN", Sale = true, Mass = "100 " });
            testProducts.Add(new Toiletry { Id = 2, Name = "Demo2", Company = "KRAS", Price = "200 KN", Sale = false, Mass = "200 " });
            testProducts.Add(new Toiletry { Id = 3, Name = "Demo3", Company = "KRAS", Price = "200 KN", Sale = false, Mass = "300 " });

            return testProducts;
        }

        private List<Clothing> GetTestClothes()
        {
            var testProducts = new List<Clothing>();
            testProducts.Add(new Clothing { Id = 1, Name = "Demo1", Company = "KRAS", Price = "100 KN", Sale = true, Size = "100" });
            testProducts.Add(new Clothing { Id = 2, Name = "Demo2", Company = "KRAS", Price = "200 KN", Sale = false, Size = "200" });
            testProducts.Add(new Clothing { Id = 3, Name = "Demo3", Company = "KRAS", Price = "200 KN", Sale = false, Size = "300" });

            return testProducts;
        }

        private List<Device> GetTestDevices()
        {
            var testProducts = new List<Device>();
            testProducts.Add(new Device { Id = 1, Name = "Demo1", Company = "KRAS", Price = "100 KN", Sale = true, Material = "plastic" });
            testProducts.Add(new Device { Id = 2, Name = "Demo2", Company = "KRAS", Price = "200 KN", Sale = false, Material = "metal" });
            testProducts.Add(new Device { Id = 3, Name = "Demo3", Company = "KRAS", Price = "200 KN", Sale = false, Material = "plastic" });

            return testProducts;
        }

        private List<string> GetTestCategories()
        {
            List<string> categories = new List<string>();
            categories.Add("food");
            categories.Add("beverage");
            categories.Add("devices");
            categories.Add("toiletries");
            categories.Add("categories");

            return categories;
        }
    }
}