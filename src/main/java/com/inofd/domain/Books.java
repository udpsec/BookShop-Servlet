package com.inofd.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Books {
    private String id = UUID.randomUUID().toString();
    private String name;
    private double price;
    private int pnum;
    private String category;
    private String description;
}
