package com.gp.task.repository;

import com.gp.task.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// public interface DeviceRepository extends JpaRepository<Device, String> {
public interface DeviceRepository {
    List<Device> findAll();

    Device findBySerialNoAndMachineCode(String serialNo, String machineCode);

    Device findBySerialNo(String serialNo);

    Device findByMachineCode(String machineCode);

    void updateDevice(Device device);

    void save(Device device);
}
