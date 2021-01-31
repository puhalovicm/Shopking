using System;
namespace Shopking.Models
{
    public class Clothing : Item
    {
        public virtual string Size { get; set; }

        public Clothing()
        {
        }
    }
}
