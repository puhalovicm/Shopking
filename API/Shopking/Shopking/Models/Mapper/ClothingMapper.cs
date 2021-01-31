using System;
using Shopking.Models.Dto;

namespace Shopking.Models.Mapper
{
    public class ClothingMapper
    {
        public static ClothingDto map(Clothing clothing)
        {
            return new ClothingDto(
                clothing.Id,
                clothing.Name,
                clothing.Company,
                clothing.Price,
                clothing.Sale,
                clothing.Size
            );
        }
    }
}
