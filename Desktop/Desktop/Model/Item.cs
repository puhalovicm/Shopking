using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Desktop.Model
{
    public class Item
    {
        public virtual int Id { get; set; }
        public virtual string Name { get; set; }
        public virtual string Company { get; set; }
        public virtual string Price { get; set; }
        public virtual bool Sale { get; set; }
        public virtual bool ShoppingList { get; set; }
        public virtual bool WishList { get; set; }
        public Item() { }
            
        public Item(int id, string name, string company, string price, bool sale, bool shoppingList, bool wishList) 
        {
            Id = id;
            Name = name;
            Company = company;
            Price = price;
            Sale = sale;
            ShoppingList = shoppingList;
            WishList = wishList;
        }
    }
}
