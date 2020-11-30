package com.hzp.order.service.impl;

import com.hzp.order.entity.Order;
import com.hzp.order.mapper.OrderMapper;
import com.hzp.order.service.OrderService;
import com.hzp.common.dto.OrderDTO;
import com.hzp.common.dto.StorageDTO;
import com.hzp.common.dubbo.StorageDubboService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Reference
    StorageDubboService storageDubboService;

    AtomicInteger order_id = new AtomicInteger(0);

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @GlobalTransactional
    public void createOrder(OrderDTO orderDTO) throws Exception {


        logger.info("开始全局事务。XID:{}",RootContext.getXID());

        StorageDTO storageDTO = new StorageDTO();
        storageDTO.setCount(orderDTO.getCount());
        storageDTO.setCommodityCode(orderDTO.getCommodityCode());

        //1、扣减库存
        storageDubboService.decreaseStorage(storageDTO);


        //2、创建订单
        orderDTO.setOrderNo(UUID.randomUUID().toString());
        orderDTO.setCommodityCode(orderDTO.getCommodityCode());
        orderDTO.setCount(orderDTO.getCount());
        orderDTO.setAmount(orderDTO.getAmount());
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO,order);
        //模拟异常回滚情况
        if(orderDTO.getCount()>20){
            throw new Exception("购买数量不能超过20个");
        }
        orderMapper.createOrder(order);

        logger.info("订单已创建：{}",orderDTO.getOrderNo());
    }
}
