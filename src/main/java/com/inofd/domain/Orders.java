package com.inofd.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Orders {
    private String id;

    private Double money;

    private String receiveraddress;

    private String receivername;

    private String receiverphone;

    private Integer paystate;

    private Date ordertime;

    private Integer userId;
}