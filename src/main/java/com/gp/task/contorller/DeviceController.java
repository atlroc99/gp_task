package com.gp.task.contorller;

import com.gp.task.exceptions.CustomException;
import com.gp.task.exceptions.MachineCodeNotFoundExceptionER002;
import com.gp.task.modelDto.DeviceDto;
import com.gp.task.service.DeviceService;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public ResponseEntity<List<DeviceDto>> getDevices() {
        List<DeviceDto> deviceDtos = deviceService.getDevices();
        return new ResponseEntity<>(deviceDtos, HttpStatus.OK);
    }

    @GetMapping("/{serialNo}/{machineCode}")
    public ResponseEntity<DeviceDto> getDeviceBySerialNumberAndMachineCode(@NotEmpty @PathVariable("serialNo") String serialNo,
                                                                        @NotEmpty @PathVariable("machineCode") String machineCode) throws CustomException {
        DeviceDto deviceDto = deviceService.getDeviceBySerialNumberAndMachineCode(serialNo, machineCode);
        return new ResponseEntity<>(deviceDto, HttpStatus.OK);
    }

    @GetMapping("/serialNumber/{serialNo}")
    public ResponseEntity<DeviceDto> getDeviceBySerialNumber(@NotEmpty @PathVariable("serialNo") String serialNo) throws CustomException {
        DeviceDto deviceDto = deviceService.getDeviceBySerialNumber(serialNo);
        return new ResponseEntity<>(deviceDto, HttpStatus.OK);
    }

    @GetMapping("/machineCode/{machineCode}")
    public ResponseEntity<DeviceDto> getDeviceByMachineCode(@NotEmpty @PathVariable("machineCode") String machineCode) throws CustomException {
        DeviceDto deviceDto = deviceService.getDeviceByMachineCode(machineCode);
        return new ResponseEntity<>(deviceDto, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> addDevice(@Valid @RequestBody DeviceDto deviceDto) throws Exception {
        deviceService.addDevice(deviceDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updateDevice(@RequestBody DeviceDto deviceDto) throws Exception {
        deviceService.updateDevice(deviceDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
