using System;
namespace Shopking.Models
{
    public class Device : Item
    {
        public virtual string Material { get; set; }

        public Device()
        {
        }
    }
}
