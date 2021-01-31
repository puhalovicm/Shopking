using Desktop.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Desktop.Content
{
    public class ItemContext
    {
        public List<Item> Items = new List<Item> { new Food(1, "Apple", "Poljoprivreda d.o.o", "12.4", false, true, false),
                                                    new Food(2, "Pineapple", "Poljoprivreda d.o.o", "4.4", false, false, false),
                                                    new Food(3, "Strawberry", "Poljoprivreda d.o.o", "15.0", false, false, false),
                                                    new Food(4, "Potato", "Poljoprivreda d.o.o", "1.99", false, false, false),
                                                    new Beverage(1, "Water", "Jana d.o.o", "5.5", false, false, false),
                                                    new Clothing(1, "T Shirt", "Majice d.o.o", "103.5", false, false, false),
                                                    new Device(1, "Computer x", "Kilztron d.o.o", "12000.99", false, false, false)
                                                   };
    }
}
