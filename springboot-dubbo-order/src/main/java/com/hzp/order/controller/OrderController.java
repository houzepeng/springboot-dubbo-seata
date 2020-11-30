package com.hzp.order.controller;

import com.hzp.order.service.OrderService;
import com.hzp.common.dto.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/create_order")
    public void createOrder(@RequestBody OrderDTO order)throws Exception{
        logger.info("接收到订单数据：{}",order.getCommodityCode());
        orderService.createOrder(order);
    }
}
