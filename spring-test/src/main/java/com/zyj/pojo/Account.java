package com.zyj.pojo;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Account implements Serializable {
    private int id;
    private String number;
    private double balance;
}
