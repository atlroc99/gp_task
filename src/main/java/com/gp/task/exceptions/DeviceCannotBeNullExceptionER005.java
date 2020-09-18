package com.gp.task.exceptions;

public class DeviceCannotBeNullExceptionER005 extends CustomException{
    public DeviceCannotBeNullExceptionER005() {
        super("device.not.valid", "ER0005", "Device Cannot be NULL or EMPTY");
    }
}
