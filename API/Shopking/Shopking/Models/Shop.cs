using System;
namespace Shopking.Models
{
    public class Shop
    {
        public virtual long Id { get; set; }
        public virtual string Name { get; set; }
        public virtual string Address { get; set; }

        public Shop()
        {
        }
    }
}
