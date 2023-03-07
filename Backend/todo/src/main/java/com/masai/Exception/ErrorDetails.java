package com.masai.Exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {

    public String message;

    private String description;

    private LocalDateTime timeStamp;
    
}
