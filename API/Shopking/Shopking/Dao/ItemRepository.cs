using System;
using System.Collections.Generic;
using System.Linq;
using NHibernate;
using Shopking.Models;

namespace Shopking.Dao
{
    public class ItemRepository
    {
        public IEnumerable<Item> GetItems()
        {
            using (ISession session = NHibernateSession.OpenSession())
            {
                return session.Query<Item>().ToList();
            }
        }
    }
}
