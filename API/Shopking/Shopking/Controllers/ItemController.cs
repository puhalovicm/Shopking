using System;
using System.Collections.Generic;
using Microsoft.AspNetCore.Mvc;
using Shopking.Dao;
using Shopking.Models;
using Shopking.Models.Dto;
using Shopking.Models.Mapper;

namespace Shopking.Controllers
{
    [Route("api/items")]
    public class ItemController : ControllerBase
    {
        private readonly IItemRepository itemRepository;

        public ItemController(IItemRepository itemRepository)
        {
            this.itemRepository = itemRepository;
        }

        [HttpGet]
        public IEnumerable<Item> Get()
        {
            return itemRepository.GetItems();
        }

        [HttpGet("{id}")]
        public IActionResult GetItemDetails(long id)
        {
            try
            {
                return Ok(ItemMapper.map(itemRepository.GetItemById(id)));
            }
            catch (Exception)
            {
                return BadRequest();
            }
        }

        [HttpGet("food")]
        public IEnumerable<Item> GetFoods()
        {
            return itemRepository.GetFoodItems();
        }

        [HttpGet("food/{id}")]
        public IActionResult GetFoodDetails(long id)
        {
            try
            {
                return Ok(FoodMapper.map(itemRepository.GetFoodById(id)));
            }
            catch (Exception)
            {
                return BadRequest();
            }
        }

        [HttpGet("beverage")]
        public IEnumerable<Item> GetBeverages()
        {
            return itemRepository.GetBeverageItems();
        }

        [HttpGet("beverage/{id}")]
        public IActionResult GetBeverageDetails(long id)
        {
            try
            {
                return Ok(BeverageMapper.map(itemRepository.GetBeverageById(id)));
            }
            catch (Exception)
            {
                return BadRequest();
            }
        }

        [HttpGet("clothing")]
        public IEnumerable<Item> GetClothings()
        {
            return itemRepository.GetClothingItems();
        }

        [HttpGet("clothing/{id}")]
        public IActionResult GetClothingDetails(long id)
        {
            try
            {
                return Ok(ClothingMapper.map(itemRepository.GetClothingById(id)));
            }
            catch (Exception)
            {
                return BadRequest();
            }
        }

        [HttpGet("devices")]
        public IEnumerable<Item> GetDevices()
        {
            return itemRepository.GetDeviceItems();
        }

        [HttpGet("devices/{id}")]
        public IActionResult GetDeviceDetails(long id)
        {
            try
            {
                return Ok(DeviceMapper.map(itemRepository.GetDeviceById(id)));
            }
            catch (Exception)
            {
                return BadRequest();
            }
        }

        [HttpGet("toiletries")]
        public IEnumerable<Item> GetToileries()
        {
            return itemRepository.GetToiletryItems();
        }

        [HttpGet("toiletries/{id}")]
        public IActionResult GetToiletryDetails(long id)
        {
            try
            {
                return Ok(ToiletryMapper.map(itemRepository.GetToiletryById(id)));
            }
            catch (Exception)
            {
                return BadRequest();
            }
        }

        [HttpGet("categories")]
        public List<string> GetCategories()
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
