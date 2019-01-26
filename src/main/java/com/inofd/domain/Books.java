package com.inofd.domain;

import cn.hutool.core.lang.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Books {
    private String id = UUID.randomUUID().toString().replaceAll("-","");
    private String name;
    private double price;
    private int pnum;
    private String category;
    private String description;
}
