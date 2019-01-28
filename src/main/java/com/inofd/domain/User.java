package com.inofd.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class User {
    private Integer id;

    private String username;

    private String password;

    private String gender;

    private String email;

    private String telephone;

    private String introduce;

    private String activecode;

    private Integer state;

    private String role;

    private Date registtime;
}