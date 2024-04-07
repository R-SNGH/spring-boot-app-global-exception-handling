package com.crud.demo.custom.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ControllerException extends RuntimeException{

    private static final long serialVersionUID=1L;
    private String errorCode;
    private String errorMessage;

}
