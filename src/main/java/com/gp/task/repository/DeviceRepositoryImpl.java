package com.gp.task.repository;

import com.gp.task.entity.Device;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class DeviceRepositoryImpl implements DeviceRepository {
    private List<Device> devices = new ArrayList<>();

    @Override
    public List<Device> findAll() {
        devices.add(Device.builder().serialNo("12-1222").machineCode("Machine code 1").deviceName("Motorola I").build());
        devices.add(Device.builder().serialNo("3455670-22222").machineCode("Machine code 2").deviceName("Motorola II").build());
        devices.add(Device.builder().serialNo("1-00022221").machineCode("Machine code 3").deviceName("Motorola III").build());
        return devices;
    }

    @Override
    public Device findBySerialNoAndMachineCode(String serialNo, String machineCode) {
        return devices.stream()
                .filter(device -> device.getSerialNo().equals(serialNo) && device.getMachineCode().equals(machineCode))
                .findAny()
                .orElse(null);
    }

    @Override
    public Device findBySerialNo(String serialNo) {
        return devices.stream()
                .sorted(Comparator.comparing(Device::getSerialNo))
                .filter(device -> device.getSerialNo().equals(serialNo))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Device findByMachineCode(String machineCode) {
        return devices.stream()
                .sorted(Comparator.comparing(Device::getMachineCode))
                .filter(device -> device.getMachineCode().equals(machineCode))
                .findFirst()
                .orElse(null);
    }

    @Override
    @Transactional
    public void updateDevice(Device device) {
        Device existingDevice = this.findBySerialNo(device.getSerialNo());

        existingDevice.setMachineCode(device.getMachineCode());
        existingDevice.setDeviceName(device.getDeviceName());
        save(existingDevice);
    }

    @Transactional
    public void save(Device device) {
        System.out.println("Persisting device to DB...." + device.getSerialNo() + " | "+ device.getMachineCode() + " | " + device.getDeviceName());
    }
}
