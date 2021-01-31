using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web.Http.Results;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Shopking.Controllers;
using Shopking.Dao;
using Shopking.Models;
using Shopking.Models.Dto;

namespace Shopking.Tests
{
    [TestClass]
    public class RecipeControllerTest
    {
        [TestMethod]
        public void GetAllRecipes_ShouldReturnAllRecipes()
        {
            var testShops = GetTestRecipes();
            var controller = new RecipeController(GetRepository());

            var result = controller.Get(null) as List<RecipeDto>;
            Assert.AreEqual(testShops.Count, result.Count);
        }

        [TestMethod]
        public void GetEasyRecipes_ShouldReturnEasyRecipes()
        {
            var testShops = GetTestRecipes().FindAll(r => r.Difficulty == RecipeDifficulty.EASY);
            var controller = new RecipeController(GetRepository());

            var result = controller.Get(RecipeDifficulty.EASY) as List<Recipe>;
            Assert.AreEqual(testShops.Count, result.Count);
        }

        [TestMethod]
        public void GetRecipesDetails_ShouldReturnRecipe()
        {
            var testShop = GetTestRecipes()[0];
            var controller = new RecipeController(GetRepository());

            var result = controller.GetDetails(1) as RecipeDto;
            Assert.AreEqual(testShop, result);
        }

        [TestMethod]
        public void GetDifficulties_ShouldReturnDifficulties()
        {
            var controller = new RecipeController(GetRepository());

            var result = controller.GetDifficulties() as List<String>;
            Assert.AreEqual(result.Count, Enum.GetValues<RecipeDifficulty>().ToList().Count);
        }

        private IRecipeRepository GetRepository()
        {
            return new TestRecipeRepository(GetTestRecipes());
        }

        private List<Recipe> GetTestRecipes()
        {
            var testProducts = new List<Recipe>();
            testProducts.Add(new Recipe { Id = 1, Name = "Demo1", Difficulty = RecipeDifficulty.EASY, Ingredients = GetTestFood(), Description = "BAKE", EstimatedTime = 20 });
            testProducts.Add(new Recipe { Id = 2, Name = "Demo2", Difficulty = RecipeDifficulty.DIFFICULT, Ingredients = GetTestFood(), Description = "BAKE FOOD", EstimatedTime = 30 });

            return testProducts;
        }

        private List<Food> GetTestFood()
        {
            var testProducts = new List<Food>();
            testProducts.Add(new Food { Id = 1, Name = "Demo1", Company = "KRAS", Price = "100 KN", Sale = false, Mass = "100 kg", Recipes = new List<Recipe>() });
            testProducts.Add(new Food { Id = 2, Name = "Demo2", Company = "KRAS", Price = "200 KN", Sale = false, Mass = "200 kg", Recipes = new List<Recipe>() });

            return testProducts;
        }
    }
}