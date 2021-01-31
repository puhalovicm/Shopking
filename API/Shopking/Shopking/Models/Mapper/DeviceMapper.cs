using System;
using Shopking.Models.Dto;

namespace Shopking.Models.Mapper
{
    public class DeviceMapper
    {
        public static DeviceDto map(Device device)
        {
            return new DeviceDto(
                device.Id,
                device.Name,
                device.Company,
                device.Price,
                device.Sale,
                device.Material
            );
        }
    }
}
