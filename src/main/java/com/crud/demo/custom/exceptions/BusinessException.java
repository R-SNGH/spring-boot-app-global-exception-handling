package com.crud.demo.custom.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serial;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID=1L;
    private String errorCode;
    private String errorMessage;

}
