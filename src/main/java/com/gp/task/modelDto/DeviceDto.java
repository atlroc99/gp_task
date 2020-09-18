package com.gp.task.modelDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceDto {
    @NotEmpty(message = "Serial number cannot be empty")
    private String serialNo;

    @NotEmpty(message = "Macnine Code cannot be empty")
    private String machineCode;

    @NotEmpty(message = "Device name cannot be empty")
    private String deviceName;
}
