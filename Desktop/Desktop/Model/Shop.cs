using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Desktop.Model
{
    public class Shop
    {
        public virtual int Id { get; set; }
        public virtual string Name { get; set; }
        public virtual string Address { get; set; }

        public Shop(int id, string name, string address) 
        {
            Id = id;
            Name = name;
            Address = address;
        }
    }
}
