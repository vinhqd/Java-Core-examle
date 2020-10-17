package com.ex.dao;

import com.ex.model.OrderModel;

import java.util.List;

public interface IOrderDAO {
    List<OrderModel> findAll();

    List<OrderModel> findByUser(long userId);

    List<OrderModel> findByStatus(int  status);

    OrderModel findOne(long orderId);

    OrderModel insert(OrderModel orderModel);

    OrderModel update(int index, OrderModel orderModel);
}
