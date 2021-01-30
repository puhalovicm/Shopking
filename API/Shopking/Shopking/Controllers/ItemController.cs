using System;
using System.Collections.Generic;
using Microsoft.AspNetCore.Mvc;
using Shopking.Dao;
using Shopking.Models;

namespace Shopking.Controllers
{
    [Route("api/items")]
    public class ItemController : ControllerBase
    {
        private readonly ItemRepository itemRepository;

        public ItemController(ItemRepository itemRepository)
        {
            this.itemRepository = itemRepository;
        }

        [HttpGet]
        public IEnumerable<Item> Get()
        {
            return itemRepository.GetItems();
        }
    }
}
