package com.grabandgo.grabandgo_backend.errorsHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    
    private String message;
    private String details;

}
