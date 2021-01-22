using Microsoft.AspNetCore.Mvc;
using NHibernate;
using Shopking.Models;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Shopking.Controllers
{
    [Route("api/[controller]")]
    public class ShopController : ControllerBase
    {
        public ShopController()
        {
        }

        [HttpGet]
        public IEnumerable<Shop> Get()
        {
            using (ISession session = NHibernateSession.OpenSession())  // Open a session to conect to the database
            {
                return session.Query<Shop>().ToList();
            }
            //return _dataAccessProvider.GetShops();
        }
    }
}
