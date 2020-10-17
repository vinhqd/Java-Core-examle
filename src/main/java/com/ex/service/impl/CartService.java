package com.ex.service.impl;

import com.ex.dao.ICartDAO;
import com.ex.dao.IUserDAO;
import com.ex.dao.impl.CartDAO;
import com.ex.dao.impl.UserDAO;
import com.ex.data.CreateData;
import com.ex.model.CartModel;
import com.ex.model.ProductModel;
import com.ex.service.ICartService;

import java.util.ArrayList;
import java.util.List;

public class CartService implements ICartService {
    private ICartDAO cartDAO;
    private IUserDAO userDAO;

    public CartService() {
        if (cartDAO == null) cartDAO = new CartDAO();
        if (userDAO == null) userDAO = new UserDAO();
    }

    @Override
    public CartModel findOne(long userId) {
        return cartDAO.findOne(userId);
    }

    @Override
    public List<ProductModel> addToCart(long userId, ProductModel productModel) {
        CartModel cartModel = cartDAO.findOne(userId);
        if (cartModel == null) {
            CartModel cartModel1 = new CartModel();
            cartModel1.setUserId(userId);
            cartModel1.setUserModel(userDAO.findOne(cartModel1.getUserId()));
            cartModel1.getProductModels().add(productModel);
            CreateData.cartModels.add(cartModel1);
            return cartDAO.findOne(userId).getProductModels();
        } else {
            cartModel.getProductModels().add(productModel);
        }
        return cartModel.getProductModels();
    }

    @Override
    public List<ProductModel> removeProductFromCart(long userId, ProductModel productModel) {
        CartModel cartModel = cartDAO.findOne(userId);
        if (cartModel != null) {
            cartModel.getProductModels().remove(productModel);
            return cartModel.getProductModels();
        }
        return null;
    }

    @Override
    public void removeCart(long userId) {
        for(CartModel cartModel: CreateData.cartModels) {
            if (cartModel.getUserId().equals(userId)) {
                cartModel.setProductModels(new ArrayList<ProductModel>());
            }
        }
    }
}
