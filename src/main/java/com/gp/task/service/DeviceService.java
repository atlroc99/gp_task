package com.gp.task.service;

import com.gp.task.entity.Device;
import com.gp.task.exceptions.CustomException;
import com.gp.task.modelDto.DeviceDto;
import com.gp.task.repository.DeviceRepository;
import com.gp.task.exceptions.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;

@Service
@Slf4j
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    private final List<DeviceDto> deviceDtos = new ArrayList<>();

    public List<DeviceDto> getDevices() {
        ObjectMapper mapper = new ObjectMapper();
        deviceRepository.findAll().forEach(device -> {
            deviceDtos.add(mapper.convertValue(device, DeviceDto.class));
        });
        return deviceDtos;
    }

    public DeviceDto getDeviceBySerialNumber(String serialNo) throws CustomException {
        if (isNullOrEmpty(serialNo) || !isValid(serialNo)) {
            throw new InvalidSerialNumberExceptionER003();
        }

        Device device = deviceRepository.findBySerialNo(serialNo);
        if (device == null) {
            throw new SerialNumberNotFoundExceptionER004();
        }

        return new ObjectMapper().convertValue(device, DeviceDto.class);
    }

    public DeviceDto getDeviceByMachineCode(String machineCode) throws CustomException {
        if (isNullOrEmpty(machineCode)) {
            throw new InvalidMachineCodeExceptionER001();
        }

        Device device = deviceRepository.findByMachineCode(machineCode);
        if (device == null) {
            throw new MachineCodeNotFoundExceptionER002();
        }

        return getObjectMapper().convertValue(device, DeviceDto.class);
    }

    public DeviceDto getDeviceBySerialNumberAndMachineCode(String serialNo, String machineCode) throws CustomException {
        if (isNullOrEmpty(serialNo) || !isValid(serialNo)) {
            throw new InvalidSerialNumberExceptionER003();
        }
        if (isNullOrEmpty(machineCode)) {
             throw new InvalidMachineCodeExceptionER001();
        }

        Device device = deviceRepository.findBySerialNoAndMachineCode(serialNo, machineCode);
        if (device == null) {
            throw new SerialNumberNotFoundExceptionER004();
        }

        return getObjectMapper().convertValue(device, DeviceDto.class);
    }

    public void addDevice(DeviceDto deviceDto) throws CustomException {
        if (Objects.isNull(deviceDto)) {
            throw new DeviceCannotBeNullExceptionER005();
        }

        if (isNullOrEmpty(deviceDto.getSerialNo()) || !isValid(deviceDto.getSerialNo())) {
            throw new InvalidSerialNumberExceptionER003();
        }
        if (isNullOrEmpty(deviceDto.getMachineCode())) {
            throw new InvalidMachineCodeExceptionER001();
        }

        deviceRepository.save(getObjectMapper().convertValue(deviceDto, Device.class));
    }

    public void updateDevice(DeviceDto deviceDto) throws Exception {
        if (deviceDto == null) {
            throw new Exception("Object [Device] cannot be null");
        }

        DeviceDto existingDevice = getDeviceBySerialNumber(deviceDto.getSerialNo());
        if (existingDevice == null) {
            CustomException er003 = new InvalidSerialNumberExceptionER003();
            log.error("ResourceKey: " + er003.getResourceKey() + " | ErrorCode: " + er003.getErrorCode() + " | " + er003.getMessage());
            log.info("Retry getting device by machineCode...");
            existingDevice = getDeviceByMachineCode(deviceDto.getMachineCode());
        }
        if (existingDevice == null) {
            throw new SerialNumberNotFoundExceptionER004();
        }

        deviceRepository.save(new ObjectMapper().convertValue(existingDevice, Device.class));
    }

    private boolean isValid(String serialNo) {
        if (isNullOrEmpty(serialNo)) {
            return false;
        }

        List<String> regExs = Arrays.asList("^[0-9]{1}+-[0-9]{8}$", "^[0-9]{2}+-[0-9]{4}$", "^[0-9]{7}+-[0-9]{5}$");
        boolean isValid = false;

        for (String regEx : regExs) {
            Predicate<String> p = Pattern.compile(regEx).asPredicate();
            if (p.test(serialNo)) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }

    private boolean isNullOrEmpty(String value) {
        return StringUtils.isEmpty(value);
    }

    private ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }
}
