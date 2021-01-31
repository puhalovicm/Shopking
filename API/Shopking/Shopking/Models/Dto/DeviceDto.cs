using System;
namespace Shopking.Models.Dto
{
    public class DeviceDto
    {
        public virtual long Id { get; set; }
        public virtual string Name { get; set; }
        public virtual string Company { get; set; }
        public virtual string Price { get; set; }
        public virtual bool Sale { get; set; }
        public virtual string Material { get; set; }

        public DeviceDto(long id, string name, string company, string price, bool sale, string material)
        {
            Id = id;
            Name = name;
            Company = company;
            Price = price;
            Sale = sale;
            Material = material;
        }
    }
}
