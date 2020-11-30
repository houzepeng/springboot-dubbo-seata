package com.hzp.order.dubbo;

import com.hzp.common.dto.OrderDTO;
import com.hzp.common.dubbo.OrderDubboService;
import com.hzp.order.service.OrderService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OrderDubboServiceImpl implements OrderDubboService {


    @Autowired
    OrderService orderService;

    @Override
    public void createOrder(OrderDTO order)throws Exception {
        orderService.createOrder(order);
    }
}
