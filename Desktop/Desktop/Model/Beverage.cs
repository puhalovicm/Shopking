using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Desktop.Model
{
    public class Beverage : Item
    {
        public virtual string Volume { get; set; }

        public Beverage(int id, string name, string company, string price, bool sale, bool shoppingList, bool wishList)
            : base(id, name, company, price, sale, shoppingList, wishList) { }
    }
}
