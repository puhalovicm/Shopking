using System;
namespace Shopking.Models
{
    public class Item
    {
        public virtual long Id { get; set; }
        public virtual string Name { get; set; }
        public virtual string Company { get; set; }
        public virtual int Price { get; set; }
        public virtual bool Sale { get; set; }

        public Item()
        {
        }
    }
}
