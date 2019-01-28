package com.inofd.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Products {
    private String id;

    private String name;

    private Double price;

    private String category;

    private Integer pnum;

    private String imgurl;

    private String description;
}