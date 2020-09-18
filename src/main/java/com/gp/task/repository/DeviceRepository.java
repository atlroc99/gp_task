package com.gp.task.repository;

import com.gp.task.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {
    List<Device> findAll();
    Device findBySerialNoAndMachineCode(String serialNo, String machineCode);
    Device findBySerialNo(String serialNo);
    Device findByMachineCode(String machineCode);
}
