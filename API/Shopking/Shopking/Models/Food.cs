using System;
namespace Shopking.Models
{
    public class Food : Item
    {

        public virtual string Mass { get; set; }

        public Food()
        {
        }
    }
}
