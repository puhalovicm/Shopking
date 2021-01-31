using Microsoft.AspNetCore.Mvc;
using NHibernate;
using Shopking.Dao;
using Shopking.Models;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Shopking.Controllers
{
    [Route("api/shops")]
    public class ShopController : ControllerBase
    {
        private readonly IShopRepository shopRepository;

        public ShopController(IShopRepository shopRepository)
        {
            this.shopRepository = shopRepository;
        }

        [HttpGet]
        public IEnumerable<Shop> Get()
        {
            return shopRepository.GetShops();
        }
    }
}
