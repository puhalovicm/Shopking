using Desktop.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Desktop.Content
{
    public class InformationContext
    {
        public List<Information> informations = new List<Information> { new Information("Apples are on sale!"),
                                                                new Information("T-Shirt is on sale!" )
                                                                };
    }
}
