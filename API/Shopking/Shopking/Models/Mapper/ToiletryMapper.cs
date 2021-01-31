using System;
using Shopking.Models.Dto;

namespace Shopking.Models.Mapper
{
    public class ToiletryMapper
    {
        public static ToiletryDto map(Toiletry toiletry)
        {
            return new ToiletryDto(
                toiletry.Id,
                toiletry.Name,
                toiletry.Company,
                toiletry.Price,
                toiletry.Sale,
                toiletry.Mass
            );
        }
    }
}
