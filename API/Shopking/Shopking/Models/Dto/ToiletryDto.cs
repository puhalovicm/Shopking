using System;
namespace Shopking.Models.Dto
{
    public class ToiletryDto
    {
        public virtual long Id { get; set; }
        public virtual string Name { get; set; }
        public virtual string Company { get; set; }
        public virtual string Price { get; set; }
        public virtual bool Sale { get; set; }
        public virtual string Mass { get; set; }

        public ToiletryDto(long id, string name, string company, string price, bool sale, string mass)
        {
            Id = id;
            Name = name;
            Company = company;
            Price = price;
            Sale = sale;
            Mass = mass;
        }
    }
}
