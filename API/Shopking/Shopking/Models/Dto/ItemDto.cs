using System;
namespace Shopking.Models.Dto
{
    public class ItemDto
    {
        public virtual long Id { get; set; }
        public virtual string Name { get; set; }
        public virtual string Company { get; set; }
        public virtual string Price { get; set; }
        public virtual bool Sale { get; set; }

        public ItemDto(long id, string name, string company, string price, bool sale)
        {
            Id = id;
            Name = name;
            Company = company;
            Price = price;
            Sale = sale;
        }
    }
}
