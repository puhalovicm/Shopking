using System;
using Shopking.Models.Dto;

namespace Shopking.Models.Mapper
{
    public class BeverageMapper
    {
        public static BeverageDto map(Beverage beverage)
        {
            return new BeverageDto(
                beverage.Id,
                beverage.Name,
                beverage.Company,
                beverage.Price,
                beverage.Sale,
                beverage.Volume
            );
        }
    }
}
