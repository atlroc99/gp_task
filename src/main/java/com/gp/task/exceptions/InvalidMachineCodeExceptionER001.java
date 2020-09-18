package com.gp.task.exceptions;

import lombok.extern.slf4j.Slf4j;

public class InvalidMachineCodeExceptionER001 extends CustomException {

    public InvalidMachineCodeExceptionER001() {
        super("machine.code.invalid", "ER001", "The machine code is incorrect. Check the Machine code you provided and try again.");
    }
}
