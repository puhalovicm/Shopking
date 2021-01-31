using Desktop.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Desktop.Content
{
    public class ShopContext
    {
        public List<Shop> shops = new List<Shop> { new Shop(1, "Kauflord", "Ulica 1"),
                                                    new Shop(2, "Trgo", "Ulica p")
                                                };
    }
}
