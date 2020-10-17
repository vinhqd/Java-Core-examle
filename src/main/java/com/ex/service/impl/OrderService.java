package com.ex.service.impl;

import com.ex.dao.IOrderDAO;
import com.ex.dao.impl.OrderDAO;
import com.ex.model.OrderModel;
import com.ex.service.IOrderService;

import java.util.List;

public class OrderService implements IOrderService {
    private IOrderDAO orderDAO;

    public OrderService() {
        if (orderDAO == null) orderDAO = new OrderDAO();
    }

    @Override
    public List<OrderModel> findAll() {
        return orderDAO.findAll();
    }

    @Override
    public List<OrderModel> findByUser(long userId) {
        return orderDAO.findByUser(userId);
    }

    @Override
    public List<OrderModel> findByStatus(int status) {
        return orderDAO.findByStatus(status);
    }

    @Override
    public OrderModel findOne(long orderId) {
        return orderDAO.findOne(orderId);
    }

    @Override
    public OrderModel insert(OrderModel orderModel) {
        return orderDAO.insert(orderModel);
    }

    @Override
    public OrderModel update(OrderModel orderModel) {
        return null;
    }
}
