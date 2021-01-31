using System;
namespace Shopking.Models.Dto
{
    public class ClothingDto
    {
        public virtual long Id { get; set; }
        public virtual string Name { get; set; }
        public virtual string Company { get; set; }
        public virtual string Price { get; set; }
        public virtual bool Sale { get; set; }
        public virtual string Size { get; set; }

        public ClothingDto(long id, string name, string company, string price, bool sale, string size)
        {
            Id = id;
            Name = name;
            Company = company;
            Price = price;
            Sale = sale;
            Size = size;
        }
    }
}
