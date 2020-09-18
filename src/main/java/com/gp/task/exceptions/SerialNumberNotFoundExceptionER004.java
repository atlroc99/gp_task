package com.gp.task.exceptions;

public class SerialNumberNotFoundExceptionER004 extends CustomException {
    public SerialNumberNotFoundExceptionER004() {
        super("serial.number.not.found", "ER004", "The serial number does not match our records.");
    }
}
