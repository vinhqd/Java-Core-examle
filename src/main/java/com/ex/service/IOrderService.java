package com.ex.service;

import com.ex.model.OrderModel;

import java.util.List;

public interface IOrderService {
    List<OrderModel> findAll();

    OrderModel insert(OrderModel orderModel);

    OrderModel update(OrderModel orderModel);

    List<OrderModel> findByUser(long userId);

    List<OrderModel> findByStatus(int status);

    OrderModel findOne(long orderId);
}
