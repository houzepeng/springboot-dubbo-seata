package com.hzp.common.dubbo;

import com.hzp.common.dto.OrderDTO;

public interface OrderDubboService {

    void createOrder(OrderDTO order) throws Exception;
}
