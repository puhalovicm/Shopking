using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.AspNetCore.Mvc;
using Shopking.Dao;

namespace Shopking.Controllers
{
    [Route("api/notifications")]
    public class NotificationsController : ControllerBase
    {
        private ItemRepository itemRepository;

        public NotificationsController(ItemRepository itemRepository)
        {
            this.itemRepository = itemRepository;
        }

        [HttpPost]
        public IEnumerable<long> GetDetails([FromBody]List<long> ids)
        {
            return itemRepository.GetSaleItemsByIds(ids).ToList().Select(i => i.Id);
        }
    }
}
