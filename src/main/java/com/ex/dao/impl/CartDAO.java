package com.ex.dao.impl;

import com.ex.dao.ICartDAO;
import com.ex.data.CreateData;
import com.ex.model.CartModel;
import com.ex.model.ProductModel;

import java.util.List;

public class CartDAO extends AbstractDAO<CartModel> implements ICartDAO {
    @Override
    public List<CartModel> findAll() {
        return CreateData.cartModels;
    }

    @Override
    public CartModel findOne(long userId) {
        List<CartModel> cartModels = findAll();
        for (CartModel cartModel: cartModels) {
            if (cartModel.getUserId().equals(userId)) {
                return cartModel;
            }
        }
        return null;
    }

    @Override
    public List<ProductModel> insert(int index, ProductModel productModel) {
        List<CartModel> cartModels = findAll();
        cartModels.get(index).getProductModels().add(productModel);
        return cartModels.get(index).getProductModels();
    }

    @Override
    public List<ProductModel> delete(int index, ProductModel productModel) {
        List<CartModel> cartModels = findAll();
        cartModels.get(index).getProductModels().remove(productModel);
        return cartModels.get(index).getProductModels();
    }
}
