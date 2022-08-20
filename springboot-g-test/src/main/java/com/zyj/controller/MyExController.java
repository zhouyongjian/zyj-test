package com.zyj.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice
@Slf4j
@RestControllerAdvice
public class MyExController {


    @ExceptionHandler(Exception.class)
    public String handlerException(Exception e){
        log.error("异常：{}",e);
        return "hh";
    }
}
