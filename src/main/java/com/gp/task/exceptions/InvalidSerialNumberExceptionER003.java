package com.gp.task.exceptions;

public class InvalidSerialNumberExceptionER003 extends CustomException {
    public InvalidSerialNumberExceptionER003() {
        super("serial.number.invalid", "ER003", "The serial number entered can include a - z, A - Z, 0 - 9 and hyphen. Please correct your entry.");
    }
}
