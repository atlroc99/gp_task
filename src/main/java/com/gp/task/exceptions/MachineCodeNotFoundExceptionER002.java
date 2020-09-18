package com.gp.task.exceptions;

public class MachineCodeNotFoundExceptionER002 extends CustomException {
    public MachineCodeNotFoundExceptionER002() {
        super("machine.code.not.found", "ER002","The machine code does not match our records.");
    }
}
