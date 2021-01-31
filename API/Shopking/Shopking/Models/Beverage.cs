using System;
namespace Shopking.Models
{
    public class Beverage : Item
    {
        public virtual string Volume { get; set; }

        public Beverage()
        {
        }
    }
}
