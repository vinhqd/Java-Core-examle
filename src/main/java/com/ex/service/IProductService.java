package com.ex.service;

import com.ex.model.ProductModel;

import java.util.List;

public interface IProductService {
    List<ProductModel> findAll();

    List<ProductModel> findByName(String name);

    List<ProductModel> findByPrice(double price, String choose);

    List<ProductModel> findByCategory(long categoryId);

    ProductModel insert(ProductModel productModel);

    ProductModel findOne(long id);

    ProductModel update(int index, ProductModel productModel);
}
