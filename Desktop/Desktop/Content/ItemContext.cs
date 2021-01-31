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
        public List<Item> Items = new List<Item> { new Item(1, "Apple", "Poljoprivreda d.o.o", "12.4", false, true, false),
                                                    new Item(2, "Apple", "Poljoprivreda d.o.o", "12.4", false, false, false),
                                                    new Item(3, "Apple", "Poljoprivreda d.o.o", "12.4", false, false, false),
                                                    new Item(4, "Apple", "Poljoprivreda d.o.o", "12.4", false, false, false),
                                                    new Item(5, "Apple", "Poljoprivreda d.o.o", "12.4", false, false, false),
                                                    new Item(6, "Apple", "Poljoprivreda d.o.o", "12.4", false, false, false),
                                                    new Item(7, "Apple", "Poljoprivreda d.o.o", "12.4", false, false, false)
                                                   };
    }
}
