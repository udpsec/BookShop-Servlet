package com.inofd.dao;

import com.inofd.domain.Orderitem;
import org.apache.ibatis.annotations.Param;

public interface OrderitemMapper {
    int deleteByPrimaryKey(@Param("orderId") String orderId, @Param("productId") String productId);

    int insert(Orderitem record);

    int insertSelective(Orderitem record);

    Orderitem selectByPrimaryKey(@Param("orderId") String orderId, @Param("productId") String productId);

    int updateByPrimaryKeySelective(Orderitem record);

    int updateByPrimaryKey(Orderitem record);
}