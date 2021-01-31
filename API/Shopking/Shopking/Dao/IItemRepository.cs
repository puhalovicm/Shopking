using System;
using System.Collections.Generic;
using Shopking.Models;
using Shopking.Models.Dto;

namespace Shopking.Dao
{
    public interface IItemRepository
    {
        public IEnumerable<Item> GetItems();
        public Item GetItemById(long id);
        public IEnumerable<Item> GetItemsByIds(List<long> ids);
        public IEnumerable<Item> GetSaleItemsByIds(List<long> ids);
        public IEnumerable<Item> GetFoodItems();
        public Food GetFoodById(long id);
        public IEnumerable<Item> GetBeverageItems();
        public Beverage GetBeverageById(long id);
        public IEnumerable<Item> GetClothingItems();
        public Clothing GetClothingById(long id);
        public IEnumerable<Item> GetDeviceItems();
        public Device GetDeviceById(long id);
        public IEnumerable<Item> GetToiletryItems();
        public Toiletry GetToiletryById(long id);
    }
}
