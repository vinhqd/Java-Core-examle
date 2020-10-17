package com.ex.dao;

import com.ex.model.CartModel;
import com.ex.model.ProductModel;

import java.util.List;

public interface ICartDAO {
    List<CartModel> findAll();

    CartModel findOne(long userId);

    List<ProductModel> insert(int index, ProductModel productModel);

    List<ProductModel> delete(int index, ProductModel productModel);
}
