package com.hzp.order.service;


import com.hzp.common.dto.OrderDTO;

public interface OrderService {

    void createOrder(OrderDTO order) throws Exception;
}
