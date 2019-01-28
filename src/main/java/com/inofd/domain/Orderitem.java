package com.inofd.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Orderitem {
    private String orderId;

    private String productId;

    private Integer buynum;

}