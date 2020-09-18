package com.gp.task.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = InvalidMachineCodeExceptionER001.class)
    public ResponseEntity<CustomExceptionSchema> handleInvalidMachineCodeException(InvalidMachineCodeExceptionER001 ie) {
        CustomExceptionSchema response = new CustomExceptionSchema(ie.getResourceKey(), ie.getErrorCode(), ie.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = MachineCodeNotFoundExceptionER002.class)
    public ResponseEntity<CustomExceptionSchema> handleMachineCodeNotFound(MachineCodeNotFoundExceptionER002 ie) {
        CustomExceptionSchema response = new CustomExceptionSchema(ie.getResourceKey(), ie.getErrorCode(), ie.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = InvalidSerialNumberExceptionER003.class)
    public ResponseEntity<CustomExceptionSchema> handleInvalidSerialNumberException(InvalidSerialNumberExceptionER003 ie) {
        CustomExceptionSchema response = new CustomExceptionSchema(ie.getResourceKey(), ie.getErrorCode(), ie.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }


    @ExceptionHandler(value = SerialNumberNotFoundExceptionER004.class)
    public ResponseEntity<CustomExceptionSchema> handleSerialNumberNotFoundException(SerialNumberNotFoundExceptionER004 ie) {
        CustomExceptionSchema response = new CustomExceptionSchema(ie.getResourceKey(), ie.getErrorCode(), ie.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<CustomExceptionSchema> handleCannotBeNotNullException(DeviceCannotBeNullExceptionER005 ie) {
        CustomExceptionSchema customExceptionSchema = new CustomExceptionSchema(ie.getResourceKey(), ie.getErrorCode(), ie.getMessage());
        return new ResponseEntity<>(customExceptionSchema, HttpStatus.BAD_REQUEST);
    }
}
