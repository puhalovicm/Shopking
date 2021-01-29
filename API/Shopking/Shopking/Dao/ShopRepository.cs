using System;
using System.Collections.Generic;
using System.Linq;
using NHibernate;
using Shopking.Models;
using Shopking.Models.Mapper;

namespace Shopking.Dao
{
    public class ShopRepository
    {

        public IEnumerable<Shop> GetShops()
        {
            using (ISession session = NHibernateSession.OpenSession())
            {
                return session.Query<Shop>().ToList();
            }
        }
    }
}
