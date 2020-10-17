package com.ex.dao.impl;

import com.ex.dao.IOrderDAO;
import com.ex.data.CreateData;
import com.ex.model.OrderModel;

import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends AbstractDAO<OrderModel> implements IOrderDAO {
    @Override
    public List<OrderModel> findAll() {
        return CreateData.orderModels;
    }

    @Override
    public List<OrderModel> findByUser(long userId) {
        List<OrderModel> orderModels = findAll();
        List<OrderModel> newList = new ArrayList<>();
        for(OrderModel orderModel: orderModels) {
            if (orderModel.getUserId().equals(userId)) {
                newList.add(orderModel);
            }
        }
        return newList;
    }

    @Override
    public OrderModel findOne(long orderId) {
        List<OrderModel> orderModels = findAll();
        for (OrderModel orderModel: orderModels) {
            if (orderModel.getId().equals(orderId)) {
                return orderModel;
            }
        }
        return null;
    }

    @Override
    public List<OrderModel> findByStatus(int status) {
        List<OrderModel> orderModels = findAll();
        List<OrderModel> newList = new ArrayList<>();
        for(OrderModel orderModel: orderModels) {
            if (orderModel.getStatus() == status) {
                newList.add(orderModel);
            }
        }
        return newList;
    }

    @Override
    public OrderModel insert(OrderModel orderModel) {
        List<OrderModel> orderModels = findAll();
        orderModels.add(orderModel);
        return orderModels.get(orderModels.size() - 1);
    }

    @Override
    public OrderModel update(int index, OrderModel orderModel) {
        List<OrderModel> orderModels = findAll();
        orderModels.set(index, orderModel);
        return orderModels.get(index);
    }
}
