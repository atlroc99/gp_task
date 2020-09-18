package com.gp.task.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomExceptionSchema {
    private String resourceKey;
    private String errorCode;
    private String message;
}
