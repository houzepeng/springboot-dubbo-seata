package com.hzp.order.mapper;

import com.hzp.order.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {

    void createOrder(Order order);
}
