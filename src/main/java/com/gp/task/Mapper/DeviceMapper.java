package com.gp.task.Mapper;

import com.gp.task.entity.Device;
import com.gp.task.modelDto.DeviceDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper (componentModel = "spring")
public interface DeviceMapper {
    DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);
    DeviceDto deviceToDeviceDto(Device device);
    Device deviceDtoToDevice(DeviceDto deviceDto);
}
