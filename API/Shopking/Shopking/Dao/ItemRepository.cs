using System;
using System.Collections.Generic;
using System.Linq;
using NHibernate;
using Shopking.Models;
using Shopking.Models.Dto;
using Shopking.Models.Mapper;

namespace Shopking.Dao
{
    public class ItemRepository : IItemRepository
    {
        public IEnumerable<Item> GetItems()
        {
            using (ISession session = NHibernateSession.OpenSession())
            {
                return session.Query<Item>().ToList();
            }
        }

        public Item GetItemById(long id)
        {
            using (ISession session = NHibernateSession.OpenSession())
            {
                return session.Query<Item>().Where(r => r.Id == id).First();
            }
        }

        public IEnumerable<Item> GetItemsByIds(List<long> ids)
        {
            using (ISession session = NHibernateSession.OpenSession())
            {
                return session.Query<Item>().Where(r => ids.Contains(r.Id)).ToList();
            }
        }

        public IEnumerable<Item> GetSaleItemsByIds(List<long> ids)
        {
            using (ISession session = NHibernateSession.OpenSession())
            {
                return session.Query<Item>()
                    .Where(r => ids.Contains(r.Id) && r.Sale)
                    .ToList();
            }
        }

        public IEnumerable<Item> GetFoodItems()
        {
            using (ISession session = NHibernateSession.OpenSession())
            {
                return session.Query<Food>().ToList();
            }
        }

        public Food GetFoodById(long id)
        {
            using (ISession session = NHibernateSession.OpenSession())
            {
                return session.Query<Food>().Where(r => r.Id == id).First();
            }
        }

        public IEnumerable<Item> GetBeverageItems()
        {
            using (ISession session = NHibernateSession.OpenSession())
            {
                return session.Query<Beverage>().ToList();
            }
        }

        public Beverage GetBeverageById(long id)
        {
            using (ISession session = NHibernateSession.OpenSession())
            {
                return session.Query<Beverage>().Where(r => r.Id == id).First();
            }
        }

        public IEnumerable<Item> GetClothingItems()
        {
            using (ISession session = NHibernateSession.OpenSession())
            {
                return session.Query<Clothing>().ToList();
            }
        }

        public Clothing GetClothingById(long id)
        {
            using (ISession session = NHibernateSession.OpenSession())
            {
                return session.Query<Clothing>().Where(r => r.Id == id).First();
            }
        }

        public IEnumerable<Item> GetDeviceItems()
        {
            using (ISession session = NHibernateSession.OpenSession())
            {
                return session.Query<Device>().ToList();
            }
        }

        public Device GetDeviceById(long id)
        {
            using (ISession session = NHibernateSession.OpenSession())
            {
                return session.Query<Device>().Where(r => r.Id == id).First();
            }
        }

        public IEnumerable<Item> GetToiletryItems()
        {
            using (ISession session = NHibernateSession.OpenSession())
            {
                return session.Query<Toiletry>().ToList();
            }
        }

        public Toiletry GetToiletryById(long id)
        {
            using (ISession session = NHibernateSession.OpenSession())
            {
                return session.Query<Toiletry>().Where(r => r.Id == id).First();
            }
        }
    }
}
