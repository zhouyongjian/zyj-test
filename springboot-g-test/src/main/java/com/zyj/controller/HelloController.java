package com.zyj.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j

public class HelloController {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @RequestMapping("/hello")
    public String hello(){

        log.info("hhhhh");
         int i = 10/0;
        return
                "hello springboot 2";
    }



}
