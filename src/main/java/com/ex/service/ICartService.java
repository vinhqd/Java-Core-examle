package com.ex.service;

import com.ex.model.CartModel;
import com.ex.model.ProductModel;
import com.ex.model.UserModel;

import java.util.List;

public interface ICartService {
    CartModel findOne(long userId);

    List<ProductModel> addToCart(long userId, ProductModel productModel);

    void removeCart(long userId);

    List<ProductModel> removeProductFromCart(long userId, ProductModel productModel);
}
