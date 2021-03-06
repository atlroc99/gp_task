package com.gp.task.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Device {
    @Id
    private String ID;
    private String serialNo;
    private String machineCode;
    private String deviceName;
}
