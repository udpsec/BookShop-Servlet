package com.inofd.dao;

import com.inofd.domain.Products;

public interface ProductsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Products record);

    int insertSelective(Products record);

    Products selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Products record);

    int updateByPrimaryKey(Products record);
}