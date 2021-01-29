using System;
using System.Collections.Generic;

namespace Shopking.Models.Dto
{
    public class IngredientDto
    {
        public virtual long Id { get; set; }
        public virtual string Name { get; set; }

        public IngredientDto(long id, string name)
        {
            Id = id;
            Name = name;
        }
    }
}
