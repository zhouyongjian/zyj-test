package com.zyj.springmybatis.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Setter
@Getter
@ToString
public class User  implements Serializable {
    private Integer id;
    private String name;
    private String password;
}
