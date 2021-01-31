using System;
using System.Collections.Generic;
using Shopking.Dao;
using Shopking.Models;
using Shopking.Models.Dto;

namespace Shopking.Tests
{
    public class TestItemRepository : IItemRepository
    {
        private List<Item> items;
        private List<Food> foods;
        private List<Beverage> beverages;
        private List<Toiletry> toiletries;
        private List<Clothing> clothing;
        private List<Device> devices;

        public TestItemRepository(List<Item> items, List<Food> foods, List<Beverage> beverages, List<Toiletry> toiletries, List<Clothing> clothing, List<Device> devices)
        {
            this.items = items;
            this.foods = foods;
            this.beverages = beverages;
            this.toiletries = toiletries;
            this.clothing = clothing;
            this.devices = devices;
        }

        public TestItemRepository(List<Item> items)
        {
            this.items = items;
        }

        Beverage IItemRepository.GetBeverageById(long id)
        {
            return beverages.Find(b => b.Id == id);
        }

        IEnumerable<Item> IItemRepository.GetBeverageItems()
        {
            return beverages;
        }

        Clothing IItemRepository.GetClothingById(long id)
        {
            return clothing.Find(b => b.Id == id);
        }

        IEnumerable<Item> IItemRepository.GetClothingItems()
        {
            return clothing;
        }

        Device IItemRepository.GetDeviceById(long id)
        {
            return devices.Find(b => b.Id == id);
        }

        IEnumerable<Item> IItemRepository.GetDeviceItems()
        {
            return devices;
        }

        Food IItemRepository.GetFoodById(long id)
        {
            return foods.Find(b => b.Id == id);
        }

        IEnumerable<Item> IItemRepository.GetFoodItems()
        {
            return foods;
        }

        Item IItemRepository.GetItemById(long id)
        {
            return items.Find(b => b.Id == id);
        }

        IEnumerable<Item> IItemRepository.GetItems()
        {
            return items;
        }

        IEnumerable<Item> IItemRepository.GetItemsByIds(List<long> ids)
        {
            return items.FindAll(r => ids.Contains(r.Id));
        }

        IEnumerable<Item> IItemRepository.GetSaleItemsByIds(List<long> ids)
        {
            return items.FindAll(r => ids.Contains(r.Id) && r.Sale);
        }

        Toiletry IItemRepository.GetToiletryById(long id)
        {
            return toiletries.Find(b => b.Id == id);
        }

        IEnumerable<Item> IItemRepository.GetToiletryItems()
        {
            return toiletries;
        }
    }
}
