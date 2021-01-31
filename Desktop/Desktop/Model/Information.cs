using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Desktop.Model
{
    public class Information
    {
        public virtual string Info { get; set; }

        public Information(string info) 
        {
            Info = info;
        }
    }
}
