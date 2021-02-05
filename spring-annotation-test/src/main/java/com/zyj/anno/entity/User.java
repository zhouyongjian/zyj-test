package com.zyj.anno.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Setter
@Getter
public class User implements Serializable {
    private String name;
    private Integer id;
    private String password;

}
