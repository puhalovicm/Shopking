using Microsoft.AspNetCore.Mvc;
using NHibernate;
using Shopking.Models;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Shopking.Controllers
{
    [Route("api/shops")]
    public class ShopController : ControllerBase
    {
        public ShopController()
        {
        }

        [HttpGet]
        public IEnumerable<Shop> Get()
        {
            using (ISession session = NHibernateSession.OpenSession()) 
            {
                return session.Query<Shop>().ToList();
            }
        }
    }
}
