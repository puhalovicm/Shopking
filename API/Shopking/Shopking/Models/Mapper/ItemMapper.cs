using System;
using Shopking.Models.Dto;

namespace Shopking.Models.Mapper
{
    public class ItemMapper
    {
        public static ItemDto map(Item item)
        {
            return new ItemDto(
                item.Id,
                item.Name,
                item.Company,
                item.Price,
                item.Sale
            );
        }
    }
}
